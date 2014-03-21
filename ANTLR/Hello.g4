// Define
grammar Hello;

//---------------Test terminals----------------
program : block ;

block
    : function block
    |
    ;

function
    : 'function' identifierOrListIndex declarationParameters 'returns' (type|nothing) //TODO: Add composite data-types
       stmts
      'endfunction'
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
    : stmt stmts
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
    ;

//----------------End Statements-----------------
//---------------Declaration---------------
declaration
    : type identifierOrListIndex (ASSIGN expression)?
    ;
//---------------Assignment---------------
assign
    : identifierOrListIndex ASSIGN expression
    ;
//---------------If statement-------------
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
//---------------Loops-------------
loop
    :  loopWhileOrUntil
    |  loopForeach
    ;

loopWhileOrUntil
    :   'repeat' ('while'|'until') LPAREN expression RPAREN
        stmts
        'endrepeat'
    ;

loopForeach
    :  'repeat' 'foreach' LPAREN type identifierOrListIndex 'in' identifierOrListIndex RPAREN
       stmts
       'endrepeat'
    ;

funcCall
    :  identifierOrListIndex funcParameters
    ;

variableMethodCall
    : identifierOrListIndex DOT funcCall
    ;

returnFunction
    : 'return' expression? // TODO change when identifierOrListIndex can be digits
    ;

condition
    : (identifierOrListIndex|literal) logicalOperator (identifierOrListIndex|literal)
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
    | expression logicalOperator expression
    | LPAREN expression RPAREN
    | funcCall
    | literal
    | collectionInit
    | constructClass
    | variableMethodCall
    | identifierOrListIndex
    ;

constructClass
    : classes LPAREN ( (expression? (',' expression)*) |  constructClassPort  ) RPAREN // Todo doesn't work with the keyword 'PORT' yet followed by Digits
    ;

constructClassPort
    : port IntegerLiteral
    ;

//-------------Variable types-------------
literal
    : booleanLiteral
    | DecimalLiteral
    | IntegerLiteral
    | StringLiteral
    ;

IntegerLiteral
    : Digits
    ;

DecimalLiteral
    : (Digits DOT Digits)
    | (Digits DOT)
    | (DOT Digits)
    ;

booleanLiteral
    : 'false'
    | 'true'
    ;

StringLiteral
    : '"' LetterOrDigit* '"'
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
    : Digit Digit*
    ;

fragment
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
// TODO remove, classes should be dynamically inserted at a later stage.
classes
    : 'Output'
    | 'Input'
    | 'Time'
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

ASSIGN          : '=';
BANG            : '!';
//TILDE           : '~';
//QUESTION        : '?';
//COLON           : ':';
SEMICOLON       : ';';

//Logical operators
logicalOperator : (EQUAL|GT|LT|LE|GE|NOTEQUAL|'AND'|'OR');
EQUAL           : '==';
GT              : '>';
LT              : '<';
LE              : '<=';
GE              : '>=';
NOTEQUAL        : '!=';
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