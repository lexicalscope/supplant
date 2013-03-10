package com.lexicalscope.supplant.supplantspecify;

import com.lexicalscope.supplant.supplantspecify.specification.ObjectReplacement;

public class ObjectReplacementBuilder implements SpecificationElementBuilder<ObjectReplacement> {
   public static ObjectReplacementBuilder noObject() {
      return new ObjectReplacementBuilder();
   }

   @Override
   public ObjectReplacement build() {
      return new ObjectReplacement();
   }
}
