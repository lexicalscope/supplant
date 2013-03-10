package com.lexicalscope.supplant.supplantspecify;

import com.lexicalscope.supplant.supplantspecify.specification.AddressMatch;

public abstract class AddressMatchBuilder implements SpecificationElementBuilder<AddressMatch> {
   public static AddressMatchBuilder wildcardAddress() {
      return new WildcardAddressMatchBuilder();
   }

   public static AddressMatchBuilder bindingWildcardAddress(final BindingBuilder bindTo) {
      return new BindingAddressMatchBuilder(bindTo);
   }

   public static AddressMatchBuilder stackAddress(final String stackVariable) {
      return new StackAddressMatchBuilder(stackVariable);
   }

   public static AddressMatchBuilder matchBoundAddress(final String variableName) {
      return new BoundAddressMatchBuilder(variableName);
   }
}
