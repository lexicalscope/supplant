grammar CtreeSpec;
import CtreeMatch, CtreeRewrite;

ctreespec: 'old:' ctreematch 'new:' ctreematch '~' rewriteseq EOF;