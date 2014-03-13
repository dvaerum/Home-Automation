// Define
grammar Hello;

//---------------Test terminals----------------
programtest : function+ ;


teststmts
    : stmt teststmts
    |
    ;

function
    : 'function' Identifier declarationParameters 'returns' type //TODO: Add composite data-types
       teststmts
      'endfunction'
    ;

funcParameters
    : LPAREN (expression (',' expression)*)? RPAREN
    ;

declarationParameters
    : LPAREN (declaration (',' declaration)*)? RPAREN
    ;

declarationParameterList
    : declaration (',' declaration)*
    ;

//---------------End test terminals----------------

//---------------Statement----------------
program : stmts
    ;

stmts
    : stmt stmts
    |
    ;

stmt
    : declaration
    | assign
    | ifStmt
    | loop
    | funcCall
    ;

loop
    :  'repeat' ('while'|'until') LPAREN expression RPAREN
       stmts
       'endrepeat'
    |   'repeat' 'foreach' LPAREN type Identifier 'in' Identifier RPAREN
       stmts
       'endrepeat'
    ;

ifStmt
    : 'if' LPAREN expression RPAREN
        stmts
        elseIfStmt*
        elseStmt?
      'endif'
    ;

elseIfStmt
    : 'elseif' LPAREN expression RPAREN
        stmts
    ;

elseStmt
    : 'else' stmts?
    ;

condition
    : (Identifier|literal) LOGICALOPERATOR (Identifier|literal)
    ;

funcCall
    :  Identifier funcParameters
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
    | expression LOGICALOPERATOR expression
    | funcCall
    | literal
    | Identifier
    | collectionInit
    ;

//---------------Declaration---------------
declaration
    : type Identifier (ASSIGN expression)?
    ;

//-------------Variable types-------------
literal
    : IntegerLiteral
    | DecimalLiteral
    | booleanLiteral
    | StringLiteral
    ;

IntegerLiteral
    : Digs
    ;

DecimalLiteral
    : (Digs DOT Digs)
    | (Digs DOT)
    | (DOT Digs)
    ;

booleanLiteral
    : 'true'
    | 'false'
    ;

StringLiteral
    : '"' LetterOrDigit* '"'
    ;

Digs
    : Digit Digit*
    ;

Digit
    : [0-9]
    ;

collectionInit
    : '{' (expression (',' expression)*)? '}'
    ;

// The Null Literal

NullLiteral
    :   'null'
    ;

// Primitive types

type
    : primitiveType
    | collectionType
    ;

primitiveType
    : 'Decimal'
    | 'Integer'
    | 'Boolean'
    | 'String'
    ;

collectionType
    : 'List' '&' type '&'
    | 'Dictionary' '&' type '&'
    ;


// Characters

DOT             : '.';
UPPERCASE       : [A-Z];
LOWERCASE       : [a-z];
CHARACTER       : (UPPERCASE | LOWERCASE);
UNDERSCORE      : '_';
//NUMBER          : [0-9];

// Operators

ASSIGN          : '=';
BANG            : '!';
//TILDE           : '~';
//QUESTION        : '?';
//COLON           : ':';
SEMICOLON       : ';';

//Logical operators
LOGICALOPERATOR : (EQUAL|GT|LT|LE|GE|NOTEQUAL|AND|OR); // TODO if GT and LT are apart of this list, the creation of List<> wont compute, atm use ï¿½ and ï¿½
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