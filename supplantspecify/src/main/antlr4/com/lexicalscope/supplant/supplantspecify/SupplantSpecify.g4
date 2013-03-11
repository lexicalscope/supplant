grammar SupplantSpecify;

specification : congruence '{' assertion '}' EOF;

congruence : Identifier ('(' snapshotMatch ')' )?;

assertion 
  : tupleMatch ('then' tupleTransform)? # TupleAssertion
  | 'unaffected' # UnaffectedAssertion
  ;
  
tupleMatch 
  : '(' tupleMatch ('=>' tupleMatch)* ')'
  | snapshotMatch
  | '_';

snapshotMatch : location? stackMatch? heapMatch?;

location : '@' Identifier ('.'('old'|'new'))?;

stackMatch : '<' variableMatch '->' (StringLiteral|objectMatch) '>';

heapMatch : '[' (heapElementMatch (',' heapElementMatch)*)? ']';

heapElementMatch : addressMatch ('->' objectMatch)?;

addressMatch 
	: '*' binding? # bindingAddressMatch
	| Identifier # boundAddressMatch
	| '<' Identifier '>' # stackAddressMatch
	;

variableMatch : Identifier;	
	
binding : ':' Identifier;

objectMatch : '{' Identifier (',' fieldMatch (fieldMatch)*)? '}' binding?;

fieldMatch : Identifier '=' fieldValue;

fieldValue : StringLiteral; 
      
tupleTransform : (snapshotTransform (',' snapshotTransform)*)?;

snapshotTransform : location heapTransform;

heapTransform : '[' addressMatch '->' objectTransform? ']';
objectTransform : Identifier? '{' (Identifier)? fieldTransform '}';
fieldTransform : Identifier '=' StringLiteral;  

// LEXER =====================================================

StringLiteral
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

fragment
HexDigit : (Digit|'a'..'f'|'A'..'F') ;

fragment
Digit : '0'..'9' ;

Identifier
	: Letter (Letter|IdDigit)*
  	;

fragment
Letter 
	: 'A'..'Z'
	| 'a'..'z'
	; 
	
fragment
IdDigit
    : '0'..'9'
    ;
    
WS
	: [ \r\t\u000C\n]+ -> channel(HIDDEN)
  	;
  	