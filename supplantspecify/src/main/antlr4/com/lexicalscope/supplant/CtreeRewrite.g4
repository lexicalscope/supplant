grammar CtreeRewrite;
import Literals, CtreeCom;

root: rewrite (',' rewrite)*  EOF;
rewrite: Location (heaprw | ctree);

node : ctree | Location;
heapValue : object | String | SymIdentifier;
value : SymIdentifier | String | Null;
memDef : identifiermatch '->' heapValue;

heaprw : '[' identifiermatch memrw ']';
memrw: directfieldrw | objectrw;

directfieldrw: pathexpression '->' value;
pathexpression: '.' Identifier ('.' Identifier)*;

objectrw: '->' (SymIdentifier | '{'  '}');

identifiermatch : Identifier | SymIdentifier;