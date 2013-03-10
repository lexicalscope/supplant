package com.lexicalscope.supplant.supplantspecify;

import com.lexicalscope.supplant.supplantspecify.specification.AddressMatch;
import com.lexicalscope.supplant.supplantspecify.specification.WildcardAddressMatch;

public class WildcardAddressMatchBuilder extends AddressMatchBuilder {
   @Override
   public AddressMatch build() {
      return new WildcardAddressMatch();
   }
}
