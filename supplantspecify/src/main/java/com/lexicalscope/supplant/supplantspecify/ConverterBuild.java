package com.lexicalscope.supplant.supplantspecify;

import ch.lambdaj.function.convert.Converter;

public class ConverterBuild<R> implements Converter<SpecificationElementBuilder<R>, R> {
   @Override
   public R convert(final SpecificationElementBuilder<R> from) {
      return from.build();
   }

   public static <R> Converter<SpecificationElementBuilder<R>, R> buildAs(final Class<R> klass) {
      return new ConverterBuild<>();
   }
}
