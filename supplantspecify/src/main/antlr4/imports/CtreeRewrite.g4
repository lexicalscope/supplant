grammar CtreeRewrite;
import Literals, CtreeCom;

rewriteseq: rewrite (',' rewrite)*;
rewrite: Location (heaprw | ctree[true]);

heaprw : '[' symidentifier memrw ']';
memrw: directfieldrw | objectrw;
directfieldrw: pathexpression '->' (SymIdentifier | String | Null);
objectrw: '->' (SymIdentifier | '{'  '}');