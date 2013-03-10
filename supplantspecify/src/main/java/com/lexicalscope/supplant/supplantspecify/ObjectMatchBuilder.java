package com.lexicalscope.supplant.supplantspecify;

import com.lexicalscope.supplant.supplantspecify.specification.ObjectMatch;


public class ObjectMatchBuilder implements SpecificationElementBuilder<ObjectMatch> {
   private String type;

   public static ObjectMatchBuilder wildcardObjectMatch() {
      return objectMatch();
   }

   public static ObjectMatchBuilder objectWithType(final String type) {
      return new ObjectMatchBuilder().withType(type);
   }

   public ObjectMatchBuilder withType(final String type) {
      this.type = type;
      return this;
   }

   public static ObjectMatchBuilder objectMatch() {
      return new ObjectMatchBuilder();
   }

   @Override
   public ObjectMatch build() {
      return new ObjectMatch(type);
   }
}
