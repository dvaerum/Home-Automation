// Define
grammar Hello;

program : expression
    ;

Assign
    :
    ;

expression
    : expression ('*'|'/'|'%') expression
    | expression ('+'|'-') expression
    | literal
    ;

literal
    :   IntegerLiteral
    |   DecimalLiteral
    ;

IntegerLiteral
    : Digs
    ;

DecimalLiteral
    : Digs DOT Digs
    | Digs
    ;


Digs
    : Digit+
    ;

Digit
    : [0-9]
    ;


// The Null Literal

NullLiteral
    :   'null'
    ;

// Characters

DOT             : '.';

// Operators

ASSIGN          : '=';
BANG            : '!';
//TILDE           : '~';
//QUESTION        : '?';
//COLON           : ':';

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