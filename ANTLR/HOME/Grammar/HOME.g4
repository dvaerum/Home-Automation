// Define
grammar HOME;

@header {
package HOME.Grammar;
}

program : newline* global block EOF ;

global
    : declaration newline+ global
    | assign newline+ global
    |
    ;

block
    : function moreFunctions
    ;

function
    : 'function' identifier declarationParameters 'returns' (type|nothing) newline+ //TODO: Add composite data-types
       stmts
      'endfunction'
    ;

// Morefunctions ensures the uniqueness of the first function, the Setup function,
// and also allows gives the option of only having the setup function without any newlines following it.
moreFunctions
    : newline+ block
    | newline*
	;

//-----------------Parameters----------------

declarationParameters
    : LPAREN (declaration (',' declaration)*)? RPAREN
    ;

//------------------Statement---------------------

stmts
    : stmt newline+ stmts
    |
    ;

stmt
    : declaration
    | assign
    | ifStmt
    | loop
    | funcCall
    | variableMethodCall
    | returnFunction
    | incDec
    ;

//--------------End Statements-----------------

//---------------Declaration---------------
declaration
    : type identifier ((AnyAssign|ASSIGN) expression)?
    ;
//---------------Assignment---------------
assign
    : (identifier|listIndex|field) (AnyAssign|ASSIGN) expression
    ;
//---------------If statement-------------
ifStmt
    : 'if' LPAREN expression RPAREN newline+
        stmts
        elseIfStmt*
        elseStmt?
      'endif'
    ;

elseIfStmt
    : 'elseif' LPAREN expression RPAREN newline+
        stmts
    ;

elseStmt
    : 'else' newline+
    stmts
    ;
//---------------Loops-------------
loop
    :  loopWhileOrUntil
    |  loopForeach
    ;

loopWhileOrUntil
    :   'repeat' ('while'|'until') LPAREN expression RPAREN newline+
        stmts
        'endrepeat'
    ;

loopForeach
    :  'repeat' 'foreach' LPAREN type identifier 'in' expression RPAREN newline+
        stmts
       'endrepeat'
    ;

// calls
funcCall
    :  identifier funcParameters
    ;

funcParameters
    : LPAREN (expression (',' expression)*)? RPAREN
    ;

variableMethodCall
    : identifier DOT funcCall
    ;

returnFunction
    : 'return' expression? // TODO change when identifierOrListIndex can be digits
    ;

incDec
    : (identifier|listIndex|field) INC
    | (identifier|listIndex|field) DEC
    ;

listIndex
    : identifier ('[' expression ']')+
    ;

field
    : identifier DOT identifier
    ;

identifier
    : IdentifierExact
    ;

IdentifierExact
    : Letter LetterOrDigit*
    ;


//---------------Expression---------------

expression
    : SUB expression
    | expression (MUL|DIV|MOD) expression
    | expression (ADD|SUB) expression
    | expression (LE | GE | GT | LT) expression
    | expression (EQUAL | NOTEQUAL) expression
    | expression and expression
    | expression or expression
    | funcCall
    | literal
    | int2dec
    | variableMethodCall
    | identifier|listIndex|field
    | LPAREN expression RPAREN
    ;


//-------------Variable types-------------
literal
    : listLiteral
    | dictionaryLiteral
    | booleanLiteral
    | DecimalLiteral
    | IntegerLiteral
    | StringLiteral
    ;

listLiteral
    : '{' (expression (',' expression)*)? '}'
    ;

dictionaryLiteral
    : '{' (dictionaryEntry (',' dictionaryEntry)*)? '}'
    ;

dictionaryEntry
    : expression ASSIGN expression
    ;

int2dec
    : IntegerLiteral
    ;

booleanLiteral
    : 'false'
    | 'true'
    ;

IntegerLiteral
    : Digits
    ;

DecimalLiteral
    : (Digits DOT Digits)
    | (Digits DOT)
    | (DOT Digits)
    ;

StringLiteral
    : '"'  ~('\r' | '\n' | '"' | '\t' )*  '"'
    ;

fragment
Letter
    : (CHARACTER|UNDERSCORE)
    ;

fragment
LetterOrDigit
    : (CHARACTER|UNDERSCORE|Digit)
    ;

fragment
Digits
    :  Digit Digit*
    ;

fragment
Digit
    : [0-9]
    ;

// The Null Literal
NullLiteral
    :   'null'
    ;

// Primitive types

type
    : collectionType
    | classes
    ;

collectionType
    : 'List' '<' type '>'
    | 'Dictionary' '<' type '>'
    ;

classes
    : IdentifierExact
    ;

// Characters
nothing         : 'Nothing';
DOT             : '.';
fragment
UPPERCASE       : [A-Z];
fragment
LOWERCASE       : [a-z];
fragment
CHARACTER       : (UPPERCASE | LOWERCASE);
fragment
UNDERSCORE      : '_';
//NUMBER          : [0-9];

// Operators

BANG            : '!';
//TILDE           : '~';
//QUESTION        : '?';
//COLON           : ':';
SEMICOLON       : ';';

//Logical operators
//logicalOperator : (EQUAL|GT|LT|LE|GE|NOTEQUAL|'AND'|'OR');

and             : 'AND';
or              : 'OR';
NOTEQUAL        : '!=';
EQUAL           : '==';
GT              : '>';
LT              : '<';
LE              : '<=';
GE              : '>=';
//AND             : 'AND';
//OR              : 'OR';

//Numerical operations
INC             : '++';
DEC             : '--';
NOUSE1          : '+-';
NOUSE2          : '-+';
ADD             : '+';
SUB             : '-';
MUL             : '*';
DIV             : '/';
MOD             : '%';
//BITAND          : '&';
//BITOR           : '|';
//CARET           : '^';

//seperators
LPAREN          : '(';
RPAREN          : ')';

AnyAssign       : (ADD_ASSIGN|SUB_ASSIGN|MUL_ASSIGN|DIV_ASSIGN|MOD_ASSIGN) ;
ASSIGN          : '=';
ADD_ASSIGN      : '+=';
SUB_ASSIGN      : '-=';
MUL_ASSIGN      : '*=';
DIV_ASSIGN      : '/=';
MOD_ASSIGN      : '%=';

//AND_ASSIGN      : '&=';
//OR_ASSIGN       : '|=';
//XOR_ASSIGN      : '^=';

//
// Whitespace and comments
//

WS  :  [ \t\u000C]+ -> skip
    ;

COMMENT
    :   '/*' .*? '*/' -> skip
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> skip
    ;

newline : '\r'? '\n' ;//| '\r';

//TODO: FIX INT VS DECIMAL ERROR