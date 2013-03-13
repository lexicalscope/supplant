package com.lexicalscope.supplant.supplantspecify;

import java.lang.reflect.Array;

import ch.lambdaj.function.convert.Converter;

public class ConverterToCellArray<T> implements Converter<T, T[]> {
   public static <T> ConverterToCellArray<T> toCellArray(final Class<T> type) {
      return new ConverterToCellArray<T>(type);
   }

   private final Class<T> type;

   private ConverterToCellArray(final Class<T> type) {
      this.type = type;
   }

   @Override
   public T[] convert(final T from) {
      @SuppressWarnings("unchecked")
      final T[] result = (T[]) Array.newInstance(type, 1);
      result[0] = from;
      return result;
   }

}
