package com.lexicalscope.supplant.supplantspecify;

import com.lexicalscope.supplant.supplantspecify.specification.AddressMatch;

public class StackAddressMatchBuilder extends AddressMatchBuilder {
   private final String stackVariable;

   public StackAddressMatchBuilder(final String stackVariable) {
      this.stackVariable = stackVariable;
   }

   @Override
   public AddressMatch build() {
      return new StackAddressMatch(stackVariable);
   }
}
