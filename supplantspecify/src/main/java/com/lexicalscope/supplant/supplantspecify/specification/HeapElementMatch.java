package com.lexicalscope.supplant.supplantspecify.specification;


public class HeapElementMatch extends AbstractSpecificationElement {
   private final AddressMatch addressMatch;
   private final ObjectMatch objectMatch;

   public HeapElementMatch(
         final AddressMatch addressMatch,
         final ObjectMatch objectMatch) {
      this.addressMatch = addressMatch;
      this.objectMatch = objectMatch;
   }
}
