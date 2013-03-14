grammar CtreeCom;

// snapshot is current "frame" (top of stack + heap reachable from top of stack)

ctree : '(' snapshot ',' (node ( ',' node )* ',')? snapshot ')';
snapshot : stack heap; 

stack : '<' (varDef (',' varDef)*)? '>';
varDef : Identifier '->' value;

heap : '[' (memDef (',' memDef )*)? ']';

object : '{' (fieldDef (',' fieldDef )*)? '}';
fieldDef : Identifier ':' value;