package com.lexicalscope.supplant;

import static com.lexicalscope.fluent.FluentDollar.$;
import static com.lexicalscope.supplant.supplantspecify.ConverterToCellArray.toCellArray;

import java.io.File;
import java.io.FileFilter;
import java.util.List;

public class AbstractRig {
   public static List<File[]> findFiles(final String directory, final String extension) {
      return $.asList(new File(directory).listFiles(new FileFilter(){
         @Override
         public boolean accept(final File pathname) {
            return pathname.isFile() && pathname.getName().endsWith(extension);
         }}))._convert(toCellArray(File.class));
   }
}
