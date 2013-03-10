package com.lexicalscope.supplant.supplantspecify;

import com.lexicalscope.supplant.supplantspecify.specification.AddressMatch;
import com.lexicalscope.supplant.supplantspecify.specification.BindingAddressMatch;

public class BindingAddressMatchBuilder extends AddressMatchBuilder {
   private final BindingBuilder bindTo;

   public BindingAddressMatchBuilder(final BindingBuilder bindTo) {
      this.bindTo = bindTo;
   }

   @Override
   public AddressMatch build() {
      return new BindingAddressMatch(bindTo != null ? bindTo.build() : null);
   }
}
