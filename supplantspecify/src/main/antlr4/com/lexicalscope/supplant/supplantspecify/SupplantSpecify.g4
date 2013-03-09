grammar SupplantSpecify;

specification : congruence '{' assertion '}';

congruence : Identifier;
assertion 
  : tuplematch ('then' actions)? # MatchAssertion
  | 'unaffected' # Unaffected
  ;
tuplematch : ( match ('=>' match)* );
match : '*';
actions : action;
action : '-';

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
  	