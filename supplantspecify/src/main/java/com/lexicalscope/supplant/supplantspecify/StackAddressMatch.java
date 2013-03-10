package com.lexicalscope.supplant.supplantspecify;

import com.lexicalscope.supplant.supplantspecify.specification.AddressMatch;

public class StackAddressMatch extends AddressMatch {
   private final String stackVariable;

   public StackAddressMatch(final String stackVariable) {
      this.stackVariable = stackVariable;
   }
}
