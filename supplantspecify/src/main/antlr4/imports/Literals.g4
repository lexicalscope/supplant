lexer grammar Literals;

// --------------------- Address
Address : Digit (Digit)*;
Null : 'null';

// --------------------- Identifier
Identifier
	: Letter IdentifierTail*
  	;

fragment
IdentifierTail : Letter|Digit;

// --------------------- String
String
	: '"' ( EscapeSequence | ~('\\'|'"') )* '"'
	;

fragment
EscapeSequence
	: '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
	| UnicodeEscape
	| OctalEscape
	;

fragment
OctalEscape
	: '\\' ('0'..'3') ('0'..'7') ('0'..'7')
	| '\\' ('0'..'7') ('0'..'7')
	| '\\' ('0'..'7')
	;

fragment
UnicodeEscape
	: '\\' 'u' HexDigit HexDigit HexDigit HexDigit
 	;


// --------------------- Letters

fragment
HexDigit : (Digit|'a'..'f'|'A'..'F') ;

fragment
Letter 
	: 'A'..'Z'
	| 'a'..'z'
	; 

fragment
Digit : '0'..'9' ;

    
// --------------------- whitespace    
    
WS
	: [ \r\t\u000C\n]+ -> channel(HIDDEN)
  	;