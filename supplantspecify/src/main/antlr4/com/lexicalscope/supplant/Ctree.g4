grammar Ctree;
import Literals;

root : ctree EOF;
ctree : '(' snapshot ',' (ctree ( ',' ctree )* ',')? snapshot ')';
snapshot : stack heap; 

// snapshot is current "frame" (top of stack + heap reachable from top of stack)

stack : '<' varDef (',' varDef)* '>';
varDef : Identifier '->' value; 

heap : '[' memDef (',' memDef )* ']';
memDef : Address '->' heapValue;
heapValue : object | String;

object : '{' (fieldDef (',' fieldDef )*)? '}';
fieldDef : Identifier ':' value;

value : Address | String | Null;