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
public class TestRigSpecification extends AbstractRig {
   @Parameters(name = "{index}: specification({0})")
   public static List<File[]> loadFiles() {
      return findFiles("src/test/resources/com/lexicalscope/supplant/supplantspecify", ".ssp");
   }

   @Parameter(0)
   public File file;

   @Test public void canParse() throws IOException {
      parse(Files.toString(file, Charset.forName("UTF8"))).specification();
   }

   public static  SupplantSpecifyParser parse(final String example) {
      final SupplantSpecifyLexer lexer = new SupplantSpecifyLexer(new ANTLRInputStream(example));
      final SupplantSpecifyParser parser = new SupplantSpecifyParser(new CommonTokenStream(lexer));
      parser.addErrorListener(new ConsoleErrorListener());
//    parser.setErrorHandler(new BailErrorStrategy());
      return parser;
   }
}
