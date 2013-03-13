package com.lexicalscope.supplant;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.google.common.io.Files;

@RunWith(Parameterized.class)
public class TestRigCtree extends AbstractRig {
   @Parameters(name = "{index}: specification({0})")
   public static List<File[]> loadFiles() {
      return findFiles("src/test/resources/com/lexicalscope/supplant/supplantctree", ".ctree");
   }

   @Parameter(0)
   public File file;

   @Test public void canParse() throws IOException {
      parse(Files.toString(file, Charset.forName("UTF8"))).ctree();
   }

   public static CtreeParser parse(final String example) {
      final CtreeLexer lexer = new CtreeLexer(new ANTLRInputStream(example));
      final CtreeParser parser = new CtreeParser(new CommonTokenStream(lexer));
      parser.addErrorListener(new ConsoleErrorListener());
//    parser.setErrorHandler(new BailErrorStrategy());
      return parser;
   }
}
