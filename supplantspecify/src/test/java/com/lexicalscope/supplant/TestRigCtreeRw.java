package com.lexicalscope.supplant;

import java.io.IOException;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestRigCtreeRw extends AbstractRig {
   @Parameters(name = "{index}: specification({0})")
   public static List<Object[]> loadFiles() {
      return findFiles("src/test/resources/com/lexicalscope/supplant/supplantctree", ".ctreerw");
   }

   @Override
   public void canParse() throws IOException {
      parse(content).root();
   }

   public static CtreeRewriteParser parse(final String example) {
      final CtreeRewriteLexer lexer = new CtreeRewriteLexer(new ANTLRInputStream(example));
      final CtreeRewriteParser parser = new CtreeRewriteParser(new CommonTokenStream(lexer));
      parser.addErrorListener(new ConsoleErrorListener());
      return parser;
   }
}
