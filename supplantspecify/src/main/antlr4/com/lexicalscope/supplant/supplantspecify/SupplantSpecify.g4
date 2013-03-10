grammar SupplantSpecify;

specification : congruence '{' assertion '}';

congruence : Identifier ('(' snapshotMatch ')' )?;

assertion 
  : tupleMatch ('then' tupleTransform)? # TupleAssertion
  | 'unaffected' # UnaffectedAssertion
  ;
  
tupleMatch : ( snapshotMatch ('=>' snapshotMatch)* );

snapshotMatch : location? stackMatch? heapMatch?;

location : '@' Identifier;

stackMatch : '<' variableMatch '->' objectMatch '>';

heapMatch : '[' (heapElementMatch (',' heapElementMatch)*)? ']';

heapElementMatch : addressMatch ('->' objectMatch)?;

addressMatch 
	: '*' binding? # bindingAddressMatch
	| Identifier # boundAddressMatch
	| '<' Identifier '>' # stackAddressMatch
	;

variableMatch : Identifier;	
	
binding : ':' Identifier;

objectMatch : '{' Identifier '}';
      
tupleTransform : (snapshotTransform (',' snapshotTransform)*)?;

snapshotTransform : location heapTransform;

heapTransform : '[' addressMatch '->' ']';

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
  	