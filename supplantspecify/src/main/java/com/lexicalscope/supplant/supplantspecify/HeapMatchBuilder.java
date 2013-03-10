package com.lexicalscope.supplant.supplantspecify;

import static com.lexicalscope.fluent.FluentDollar.$;
import static com.lexicalscope.supplant.supplantspecify.HeapElementMatchBuilder.heapElementMatch;
import static com.lexicalscope.supplant.supplantspecify.ObjectMatchBuilder.wildcardObjectMatch;

import java.util.ArrayList;
import java.util.List;

import com.lexicalscope.supplant.supplantspecify.specification.HeapElementMatch;
import com.lexicalscope.supplant.supplantspecify.specification.HeapMatch;

public class HeapMatchBuilder implements SpecificationElementBuilder<HeapMatch> {
   private final List<SpecificationElementBuilder<HeapElementMatch>> matchers = new ArrayList<>();

   public HeapMatchBuilder with(final AddressMatchBuilder addressMatch) {
      return with(addressMatch, wildcardObjectMatch());
   }

   public HeapMatchBuilder with(final AddressMatchBuilder addressMatch, final ObjectMatchBuilder objectMatch) {
      with(heapElementMatch(addressMatch, objectMatch));
      return this;
   }

   public static HeapMatchBuilder heapMatch() {
      return new HeapMatchBuilder();
   }

   public static HeapMatchBuilder heapMatch(final AddressMatchBuilder addressMatch, final ObjectMatchBuilder objectMatch) {
      return heapMatch().with(addressMatch, objectMatch);
   }

   @Override
   public HeapMatch build() {
      if(matchers.isEmpty())
      {
         matchers.add(heapElementMatch());
      }
      return new HeapMatch($(matchers)._convert(ConverterBuild.buildAs(HeapElementMatch.class)));
   }

   public void with(final HeapElementMatchBuilder heapElementMatch) {
      matchers.add(heapElementMatch);
   }
}
