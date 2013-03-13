package com.lexicalscope.supplant;

import static com.lexicalscope.fluent.FluentDollar.$;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;

import ch.lambdaj.function.convert.Converter;

import com.google.common.io.Files;

public abstract class AbstractRig {
   public static List<Object[]> findFiles(final String directory, final String extension) {
      return $.asList(new File(directory).listFiles(new FileFilter(){
         @Override
         public boolean accept(final File pathname) {
            return pathname.isFile() && pathname.getName().endsWith(extension);
         }}))._convert(new Converter<File, Object[]>() {
            @Override
            public Object[] convert(final File file) {
               final Object[] result = new Object[2];
               result[0] = file;
               try {
                  result[1] = Files.toString(file, Charset.forName("UTF8"));
               } catch (final IOException e) {
                  throw new RuntimeException(e);
               }
               return result;
            }
         });
   }

   @Parameter(0)
   public File file;

   @Parameter(1)
   public String content;

   @Test public void testit() throws IOException {
      System.out.println(file);
      canParse();
   }

   public abstract void canParse() throws IOException;
}
