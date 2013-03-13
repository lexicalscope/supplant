grammar SupplantSpecify;

specification : congruence assertion EOF;

congruence : Identifier ( '(' snapshotMatch ')' )?;

assertion : tupleMatch ( tupleTransform ) | 'unaffected';
  
tupleMatch 
  : '(' tupleMatch ('=>' tupleMatch)* ')'
  | snapshotMatch
  | '_';

snapshotMatch : location? stackMatch? heapMatch?;
stackMatch : '<' stackElementMatch (',' stackElementMatch)* '>';
heapMatch : '[' (heapElementMatch (',' heapElementMatch)*)? ']';

stackElementMatch: stackVariableMatch valueMatch?; 
heapElementMatch : heapAddressMatch binding? valueMatch?;

stackVariableMatch : Identifier pathExpression;
heapAddressMatch : ('*' | Identifier | '<' Identifier '>') pathExpression;

objectMatch : '{' (fieldMatch ( ',' fieldMatch)*)? '}' binding?;
fieldMatch : Identifier pathExpression valueMatch?;
valueMatch: '==' (StringLiteral|objectMatch);
      
tupleTransform : ('(' snapshotTransform (',' snapshotTransform)* ')')?;

snapshotTransform : location heapTransform;
heapTransform : '[' heapAddressMatch valueTransform? ']';

objectTransform : Identifier? '{' fieldTransform (',' fieldTransform )* '}';
fieldTransform : Identifier pathExpression valueTransform;  
valueTransform: '=' (StringLiteral|objectTransform|'null');

location : '@' Identifier ('.'('old'|'new'))?;
pathExpression : ('.' Identifier)*;
binding : ':' Identifier;

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



IdentifierMatch
    : (Letter IdentifierWildMatch?)
    | ( '*' IdentifierConcreteMatch?)
	;

fragment	
IdentifierWildMatch : '*'? IdentifierConcreteMatch?;

fragment    
IdentifierConcreteMatch : (IdentifierTail IdentifierWildMatch?);

       
Identifier
	: Letter IdentifierTail*
  	;

fragment
IdentifierTail : Letter|IdDigit;

fragment
Letter 
	: 'A'..'Z'
	| 'a'..'z'
	; 

fragment
Digit : '0'..'9' ;
	
fragment
IdDigit
    : '0'..'9'
    ;
    
WS
	: [ \r\t\u000C\n]+ -> channel(HIDDEN)
  	;
  	