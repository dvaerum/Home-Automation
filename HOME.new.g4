// Define
grammar HOME;

//---------------Test terminals----------------
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
    : 'function' identifierOrListIndex declarationParameters 'returns' (type|nothing) newline+ //TODO: Add composite data-types
       stmts
      'endfunction'
    ;
	
moreFunctions
    : newline+ block
    | newline*
	;
//---------------End test terminals----------------

//-----------------Parameters----------------

funcParameters
    : LPAREN (expression (',' expression)*)? RPAREN
    ;

declarationParameters
    : LPAREN (declaration (',' declaration)*)? RPAREN
    ;

declarationParameterList
    : declaration (',' declaration)*
    ;

//----------------End Parameters------------------

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

incDec
    : identifierOrListIndex INC
    | identifierOrListIndex DEC
    ;

//--------------End Statements-----------------

//---------------Declaration---------------
declaration
    : type identifierOrListIndex ((AnyAssign|ASSIGN) expression)?
    ;
//---------------Assignment---------------
assign
    : identifierOrListIndex (AnyAssign|ASSIGN) expression
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
    stmts?
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
    :  'repeat' 'foreach' LPAREN type identifierOrListIndex 'in' identifierOrListIndex RPAREN newline+
        stmts
       'endrepeat'
    ;

funcCall
    :  identifierOrListIndex funcParameters
    ;

variableMethodCall
    : identifierOrListIndex DOT funcCall (DOT funcCall)*
    ;

//variableMethodCall
//    : identifierOrListIndex DOT
//    ;


returnFunction
    : 'return' expression? // TODO change when identifierOrListIndex can be digits
    ;

condition
    : (identifierOrListIndex|literal) logicalOperator (identifierOrListIndex|literal)
//    : (identifierOrListIndex|int2dec) logicalOperator (identifierOrListIndex|int2dec)
    ;

Identifier
    : Letter LetterOrDigit*
    ;

identifierOrListIndex
    : Identifier
    | Identifier '[' expression ']'
    ;

//---------------Expression---------------

expression
    : expression ('*'|'/'|'%') expression
    | expression ('+'|'-') expression
    | ('+'|'-') expression
 //   | ('++'|'--') identifierOrListIndex
    | expression logicalOperator expression
    | funcCall
//    | int2dec
    | literal
//    | collectionInit
    | variableMethodCall
    | identifierOrListIndex
    | LPAREN expression RPAREN
    ;

//-------------Variable types-------------
literal
    : listLiteral
    | dictionaryLiteral
    | booleanLiteral
    | DecimalLiteral
    | int2dec
//    | IntegerLiteral
    | StringLiteral
    ;

int2dec
    : IntegerLiteral
    ;

listLiteral
    : '{' (expression (',' expression)*)? '}'
    ;

dictionaryLiteral
    : '{' (expression ASSIGN expression) '}'
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
    : primitiveType
    | collectionType
    | classes
    ;

primitiveType
    : 'Decimal'
    | 'Integer'
    | 'Boolean'
    | 'String'
    ;

collectionType
    : 'List' '<' type '>'
    | 'Dictionary' '<' type '>'
    ;

classes
    : Identifier
    ;

// Characters
port            : 'PORT';
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
logicalOperator : (EQUAL|GT|LT|LE|GE|NOTEQUAL|'AND'|'OR');
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
ADD             : '+';
SUB             : '-';
MUL             : '*';
DIV             : '/';
MOD             : '%';
BITAND          : '&';
BITOR           : '|';
CARET           : '^';

//seperators
LPAREN          : '(';
RPAREN          : ')';

AnyAssign       : (ADD_ASSIGN|SUB_ASSIGN|MUL_ASSIGN|DIV_ASSIGN) ;
ASSIGN          : '=';
ADD_ASSIGN      : '+=';
SUB_ASSIGN      : '-=';
MUL_ASSIGN      : '*=';
DIV_ASSIGN      : '/=';

//AND_ASSIGN      : '&=';
//OR_ASSIGN       : '|=';
//XOR_ASSIGN      : '^=';
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
	
//TODO: FIX INT VS DECIMAL ERROR