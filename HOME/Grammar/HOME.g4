// Define
grammar HOME;

@header {
package HOME.Grammar;
}

program : newline* global block EOF ;

global
    : declaration newline+ global
    |
    ;

block
    : function moreFunctions
    ;

function
    : 'function' identifier functionParameters 'returns' (type|nothing) newline+
       stmts
      'endfunction'
    ;

moreFunctions
    : newline+ block
    | newline*
	;

functionParameters
    : LPAREN ( funcParamDeclaration(',' funcParamDeclaration)*)? RPAREN
    ;

funcParamDeclaration
    : type identifier
    ;

//------------------Statement---------------------

stmts
    : stmt newline+ stmts
    |
    ;

stmt
    : declaration
    | assignment
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
assignment
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
    :  'repeat' ('while'|'until') LPAREN expression RPAREN newline+
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
    : 'return' expression?
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
    | variableMethodCall
    | identifier|listIndex|field
    | LPAREN expression RPAREN
//    | int2dec
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
SEMICOLON       : ';';

//Logical operators
and             : 'AND';
or              : 'OR';
NOTEQUAL        : '!=';
EQUAL           : '==';
GT              : '>';
LT              : '<';
LE              : '<=';
GE              : '>=';

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

//Seperators
LPAREN          : '(';
RPAREN          : ')';

AnyAssign       : (ADD_ASSIGN|SUB_ASSIGN|MUL_ASSIGN|DIV_ASSIGN|MOD_ASSIGN) ;
ASSIGN          : '=';
ADD_ASSIGN      : '+=';
SUB_ASSIGN      : '-=';
MUL_ASSIGN      : '*=';
DIV_ASSIGN      : '/=';
MOD_ASSIGN      : '%=';

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