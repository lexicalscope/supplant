package com.lexicalscope.supplant.supplantspecify;

import com.lexicalscope.supplant.supplantspecify.specification.Binding;


public class BindingBuilder  implements SpecificationElementBuilder<Binding>{
   private final String identifier;

   public BindingBuilder(final String identifier) {
      this.identifier = identifier;
   }

   public static BindingBuilder binding(final String identifier) {
      return new BindingBuilder(identifier);
   }

   @Override
   public Binding build() {
      return new Binding(identifier);
   }
}
