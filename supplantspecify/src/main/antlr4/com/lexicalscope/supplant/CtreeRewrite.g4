grammar CtreeRewrite;
import Literals;

root: rewrite (',' rewrite)*  EOF;
rewrite: Location (heaprw | ctreerw);

ctreerw : '(' snapshot ',' (ctree ( ',' ctree )* ',')? snapshot ')';
heapvalue : 

heaprw : '[' identifiermatch memrw ']';

identifiermatch : Identifier | SymIdentifier;

memrw: directfieldrw | objectrw;

directfieldrw: pathexpression '->' valuerw;
pathexpression: '.' Identifier ('.' Identifier)*;
valuerw: String | identifiermatch;

objectrw: '->' (SymIdentifier | '{'  '}');