package com.lexicalscope.supplant.supplantspecify;

import com.lexicalscope.supplant.supplantspecify.specification.AddressMatch;

public class AddressMatchBuilder implements SpecificationElementBuilder<AddressMatch> {
   private BindingBuilder bindTo;
   private String variableName;

   public static AddressMatchBuilder wildcardAddress() {
      return new AddressMatchBuilder();
   }

   public static AddressMatchBuilder wildcardAddress(final BindingBuilder bindTo) {
      return wildcardAddress().bindTo(bindTo);
   }

   public AddressMatchBuilder bindTo(final BindingBuilder bindTo) {
      this.bindTo = bindTo;
      return this;
   }

   public AddressMatchBuilder addressVariable(final String variableName) {
      this.variableName = variableName;
      return this;
   }

   public static AddressMatchBuilder matchBoundAddress(final String variableName) {
      return new AddressMatchBuilder().addressVariable(variableName);
   }

   @Override
   public AddressMatch build() {
      return new AddressMatch(variableName, bindTo != null ? bindTo.build() : null);
   }
}
