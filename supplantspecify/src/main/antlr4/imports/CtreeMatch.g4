grammar CtreeMatch;
import Literals;

ctreematch: (nodematch (',' nodematch)*)  ;
nodematch: Location? ('__' | '_' | '€' | '(' snapshotmatch ',' (ctreematch ',')? snapshotmatch')');
snapshotmatch: Location? stackmatch? heapmatch; 

stackmatch: '<' (varmatch (',' varmatch)*)? '>';
heapmatch: '[' (memmatch (',' memmatch)*)? ']';

varmatch: identifiermatch '->' valuematch;
memmatch: identifiermatch '->' heapvaluematch;

identifiermatch : SymIdentifier | Identifier;
valuematch: SymIdentifier | String | Null;
heapvaluematch: SymIdentifier | String | objectmatch;
objectmatch: '{' fieldmatch '}';
fieldmatch: identifiermatch ':' valuematch;