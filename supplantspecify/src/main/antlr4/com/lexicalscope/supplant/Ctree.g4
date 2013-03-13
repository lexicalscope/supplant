grammar Ctree;
import Literals;

root : ctree EOF;
ctree : '(' snapshot ',' (ctree ( ',' ctree )* ',')? snapshot ')';
snapshot : stack heap;

stack : '<' varDef (',' varDef)* '>';
varDef : Identifier '->' value; 

heap : '[' memDef (',' memDef )* ']';
memDef : Address '->' heapValue;
heapValue : object | String;

object : '{' (fieldDef (',' fieldDef )*)? '}';
fieldDef : Identifier ':' value;

value : Address | String | Null;
 