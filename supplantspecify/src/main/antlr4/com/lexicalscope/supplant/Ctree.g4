grammar Ctree;
import Literals, CtreeCom;

root : ctree EOF;
node: ctree;

memDef : Address '->' heapValue;
heapValue : object | String;
value : Address | String | Null;