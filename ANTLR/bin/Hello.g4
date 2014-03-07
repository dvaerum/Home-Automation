// Define
grammar Hello;

program : typeDeclarations* EOF
    ;

typeDeclarations
    :  'function' Identifier LPAREN RPAREN
       functionBody
       'endfunction'
    ;

functionBody
    : declaration functionBody
//    | controlStatements
    | assignment
//    | functionCall
    |
    ;

declaration
    : primitiveType Identifier
    ;
//---------------Statement----------------

stmts
    : stmt EOL stmts
    |
    ;

stmt
    : declaration
 //   | assignment
    ;

//---------------Assignment---------------
assignment
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

//-------------Declarations---------------



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
    : Digit+
    ;

Digit
    : NUMBER
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

//Separators
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

EOC : (EOL|EOF)
    ;

NEWLINE : '\r'? '\n'
    ;

EOL : ('\r\n'|'\n'|'\r')
    ;

WS  :  [\t\r\n\u000C]+ -> skip
    ;



COMMENT
    :   '/*' .*? '*/' -> skip
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> skip
    ;