// Define
grammar Hello;

//---------------Test terminals----------------
programtest : function+ ;


teststmts
    : stmt teststmts
    |
    ;

function
    : 'function' Identifier parameters 'returns' primitiveType //TODO: Add composite data-types
       teststmts
      'endfunction'
    ;

parameters
    : LPAREN parameterList? RPAREN
    ;

parameterList
    : declaration (',' declaration)*
    ;

//---------------End test terminals----------------

//---------------Statement----------------
program : stmts
    ;

stmts
    : stmt SEMICOLON stmts
    |
    ;

stmt
    : declaration
    | assign
    ;

//---------------Assignment---------------
assign
    : Identifier ASSIGN expression
    ;

Identifier
    : Letter LetterOrDigit*
    ;

Letter
    : (CHARACTER|UNDERSCORE)
    ;

LetterOrDigit
    : (CHARACTER|UNDERSCORE) //TODO Allow digits in variables
    ;

//---------------Expression---------------
expression
    : expression ('*'|'/'|'%') expression
    | expression ('+'|'-') expression
    | literal
    ;

//---------------Declaration---------------
declaration
    : primitiveType Identifier
    ;

//-------------Variable types-------------
literal
    : IntegerLiteral
    | DecimalLiteral
    ;

IntegerLiteral
    : Digs
    ;

DecimalLiteral
    : (Digs DOT Digs)
    | (Digs DOT)
    | (DOT Digs)
    ;

Digs
    : Digit Digit*
    ;

Digit
    : [0-9]
    ;

// The Null Literal

NullLiteral
    :   'null'
    ;

// Primitive types

primitiveType
    : 'Decimal'
    | 'Integer'
    | 'Boolean'
    ;

// Characters

DOT             : '.';
UPPERCASE       : [A-Z];
LOWERCASE       : [a-z];
CHARACTER       : (UPPERCASE | LOWERCASE);
UNDERSCORE      : '_';
NUMBER          : [0-9];

// Operators

ASSIGN          : '=';
BANG            : '!';
//TILDE           : '~';
//QUESTION        : '?';
//COLON           : ':';
SEMICOLON       : ';';

//Logical operators
EQUAL           : '==';
GT              : '>';
LT              : '<';
LE              : '<=';
GE              : '>=';
NOTEQUAL        : '!=';
AND             : 'AND';
OR              : 'OR';

//Numerical operations
INC             : '++';
DEC             : '--';
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


ADD_ASSIGN      : '+=';
SUB_ASSIGN      : '-=';
MUL_ASSIGN      : '*=';
DIV_ASSIGN      : '/=';
AND_ASSIGN      : '&=';
//OR_ASSIGN       : '|=';
//XOR_ASSIGN      : '^=';
MOD_ASSIGN      : '%=';
//
// Whitespace and comments
//

WS  :  [ \t\r\n\u000C]+ -> skip
    ;

COMMENT
    :   '/*' .*? '*/' -> skip
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> skip
    ;

//TODO: FIX INT VS DECIMAL ERROR