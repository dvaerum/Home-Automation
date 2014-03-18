// Define
grammar Hello;

program : stmts
    ;

//---------------Statement----------------

stmts
    : stmt EOL stmts*
    ;

stmt
    : assign
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
    : (CHARACTER|UNDERSCORE|NUMBER)
    ;

//---------------Expression---------------
expression
    : expression ('*'|'/'|'%') expression
    | expression ('+'|'-') expression
    | literal
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
    : Digs DOT Digs
    | Digs
    ;

Digs
    : Digit+
    ;

Digit
    : NUMBER
    ;

// The Null Literal

NullLiteral
    :   'null'
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

EOL : ('\r\n'|'\n'|'\r')
    ;

WS  :  [ \t\r\n\u000C]+ -> skip
    ;

COMMENT
    :   '/*' .*? '*/' -> skip
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> skip
    ;