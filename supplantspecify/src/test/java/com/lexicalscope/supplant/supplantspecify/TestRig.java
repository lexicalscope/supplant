package com.lexicalscope.supplant.supplantspecify;

import static com.lexicalscope.fluent.FluentDollar.$;
import static com.lexicalscope.supplant.supplantspecify.AbstractTestSpecification.parse;
import static com.lexicalscope.supplant.supplantspecify.ConverterToCellArray.toCellArray;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.google.common.io.Files;

@RunWith(Parameterized.class)
public class TestRig {
   @Parameters(name = "{index}: specification({0})")
   public static List<File[]> loadFiles() {
      final File directory = new File("src/test/resources/com/lexicalscope/supplant/supplantspecify");
      return $.asList(directory.listFiles(new FileFilter(){
         @Override
         public boolean accept(final File pathname) {
            return pathname.isFile() && pathname.getName().endsWith(".ssp");
         }}))._convert(toCellArray(File.class));
   }

   @Parameter(0)
   public File file;

   @Test public void canParse() throws IOException {
      parse(Files.toString(file, Charset.forName("UTF8"))).specification();
   }
}
