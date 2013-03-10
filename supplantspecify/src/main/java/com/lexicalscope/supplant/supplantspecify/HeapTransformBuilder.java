package com.lexicalscope.supplant.supplantspecify;

import static com.lexicalscope.supplant.supplantspecify.ObjectReplacementBuilder.noObject;

import com.lexicalscope.supplant.supplantspecify.specification.HeapTransform;


public class HeapTransformBuilder implements SpecificationElementBuilder<HeapTransform>  {
   private ObjectReplacementBuilder objectReplacement = noObject();
   private AddressMatchBuilder addressMatch;

   public static HeapTransformBuilder heapTransform(final AddressMatchBuilder addressMatch, final ObjectReplacementBuilder objectReplacement) {
      return heapTransform().with(addressMatch).with(objectReplacement);
   }

   static HeapTransformBuilder heapTransform() {
      return new HeapTransformBuilder();
   }

   public HeapTransformBuilder with(final ObjectReplacementBuilder objectReplacement) {
      if(objectReplacement != null) this.objectReplacement = objectReplacement;
      return this;
   }

   public HeapTransformBuilder with(final AddressMatchBuilder addressMatch) {
      this.addressMatch = addressMatch;
      return this;
   }

   @Override
   public HeapTransform build() {
      return new HeapTransform(
            addressMatch != null ? addressMatch.build() : null,
            objectReplacement != null ? objectReplacement.build() : null);
   }
}
