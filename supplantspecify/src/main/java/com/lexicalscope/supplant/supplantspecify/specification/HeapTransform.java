package com.lexicalscope.supplant.supplantspecify.specification;


public class HeapTransform extends AbstractSpecificationElement {
   private final AddressMatch addressMatch;
   private final ObjectReplacement objectReplacement;

   public HeapTransform(final AddressMatch addressMatch, final ObjectReplacement objectReplacement) {
      this.addressMatch = addressMatch;
      this.objectReplacement = objectReplacement;
   }
}
