package com.lexicalscope.supplant.supplantspecify;

import com.lexicalscope.supplant.supplantspecify.specification.AddressMatch;
import com.lexicalscope.supplant.supplantspecify.specification.BoundAddressMatch;

public class BoundAddressMatchBuilder extends AddressMatchBuilder {
   private final String variableName;

   public BoundAddressMatchBuilder(final String variableName) {
      this.variableName = variableName;
   }

   @Override
   public AddressMatch build() {
      return new BoundAddressMatch(variableName);
   }
}
