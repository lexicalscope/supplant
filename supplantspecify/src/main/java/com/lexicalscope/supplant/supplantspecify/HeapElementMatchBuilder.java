package com.lexicalscope.supplant.supplantspecify;

import static com.lexicalscope.supplant.supplantspecify.AddressMatchBuilder.wildcardAddress;
import static com.lexicalscope.supplant.supplantspecify.ObjectMatchBuilder.wildcardObjectMatch;

import com.lexicalscope.supplant.supplantspecify.specification.HeapElementMatch;

public class HeapElementMatchBuilder implements SpecificationElementBuilder<HeapElementMatch> {
   private AddressMatchBuilder addressMatch = wildcardAddress();
   private ObjectMatchBuilder objectMatch = wildcardObjectMatch();

   public static HeapElementMatchBuilder heapElementMatch(final AddressMatchBuilder addressMatch, final ObjectMatchBuilder objectMatch) {
      return heapElementMatch().with(addressMatch).with(objectMatch);
   }

   public static HeapElementMatchBuilder heapElementMatch() {
      return new HeapElementMatchBuilder();
   }

   public HeapElementMatchBuilder with(final ObjectMatchBuilder objectMatch) {
      if(objectMatch != null) this.objectMatch = objectMatch;
      return this;
   }

   public HeapElementMatchBuilder with(final AddressMatchBuilder addressMatch) {
      if(addressMatch != null) this.addressMatch = addressMatch;
      return this;
   }

   @Override
   public HeapElementMatch build() {
      return new HeapElementMatch(
            addressMatch != null ? addressMatch.build() :  null,
            objectMatch != null ? objectMatch.build() : null);
   }
}
