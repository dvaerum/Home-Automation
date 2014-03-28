<<<<<<< HEAD:HOME.g4
// Define
grammar HOME;

//---------------Test terminals----------------
program : global block EOF ;

global
    : declaration* newline+ global
    | assign* newline+ global
    |
    ;

block
    : function moreFunctions
    | newline*
    ;

moreFunctions
    : newline+ block
    | newline*
    ;
function
    : 'function' identifierOrListIndex declarationParameters 'returns' (type|nothing) newline+ //TODO: Add composite data-types
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
    : stmt newline+ stmts
    | newline*
    ;

newline : '\r'? '\n' | '\r';

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
    : type identifierOrListIndex (AnyAssign expression)?
    ;
//---------------Assignment---------------
assign
    : identifierOrListIndex AnyAssign expression
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
    | literal
    | collectionInit
    | constructClass
    | variableMethodCall
    | identifierOrListIndex
    | LPAREN expression RPAREN
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

AnyAssign       : (ADD_ASSIGN|SUB_ASSIGN|MUL_ASSIGN|DIV_ASSIGN|ASSIGN) ;

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

=======
// Define
grammar HOME;

//---------------Test terminals----------------
program : global block EOF ;

global
    : declaration* newline+ global
    | assign* newline+ global
    |
    ;

block
    : function moreFunctions
    | newline*
    ;

moreFunctions
    : newline+ block
    | newline*
    ;
function
    : 'function' identifierOrListIndex declarationParameters 'returns' (type|nothing) newline+ //TODO: Add composite data-types
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
    : stmt newline+ stmts
    | newline*
    ;

newline : '\r'? '\n' | '\r';

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
    : type identifierOrListIndex (AnyAssign expression)?
    ;
//---------------Assignment---------------
assign
    : identifierOrListIndex AnyAssign expression
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
    | ('+'|'-') expression
 //   | ('++'|'--') identifierOrListIndex
    | expression logicalOperator expression
    | funcCall
    | literal
    | collectionInit
    | constructClass
    | variableMethodCall
    | identifierOrListIndex
    | LPAREN expression RPAREN
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

AnyAssign       : (ADD_ASSIGN|SUB_ASSIGN|MUL_ASSIGN|DIV_ASSIGN|ASSIGN) ;

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

>>>>>>> 0e7e74e3a376e1aafe7243f066f2c8d782a9863f:HOME.g4
//TODO: FIX INT VS DECIMAL ERROR