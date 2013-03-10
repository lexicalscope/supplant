package com.lexicalscope.supplant.supplantspecify.specification;

public class AddressMatch extends AbstractSpecificationElement {
   private final String variableName;
   private final Binding bindTo;

   public AddressMatch(final String variableName, final Binding bindTo) {
      this.variableName = variableName;
      this.bindTo = bindTo;
   }
}
