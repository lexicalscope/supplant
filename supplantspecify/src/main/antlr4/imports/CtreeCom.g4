grammar CtreeCom;

// snapshot is current "frame" (top of stack + heap reachable from top of stack)
// locals[boolean rw]

ctree[boolean rw]  : '(' snapshot ',' (node ( ',' node )* ',')? snapshot ')';
snapshot : stack heap;
node: ctree[$ctree::rw] | {$ctree::rw}? Location; 

stack : '<' (varDef (',' varDef)*)? '>';
varDef : Identifier '->' value;

heap : '[' (memDef (',' memDef )*)? ']';
memDef : (Address | {$ctree::rw}? symidentifier) '->' heapValue;
heapValue : object | String | {$ctree::rw}? SymIdentifier;

object : '{' (fieldDef (',' fieldDef )*)? '}';
fieldDef : Identifier ':' value;

value : {!$ctree::rw}? Address | {$ctree::rw}? SymIdentifier | String | Null;
symidentifier : Identifier | SymIdentifier;

pathexpression: '.' Identifier ('.' Identifier)*;