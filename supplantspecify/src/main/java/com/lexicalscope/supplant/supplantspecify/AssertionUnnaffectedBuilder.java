package com.lexicalscope.supplant.supplantspecify;

import com.lexicalscope.supplant.supplantspecify.specification.Assertion;
import com.lexicalscope.supplant.supplantspecify.specification.UnaffectedAssertion;

public class AssertionUnnaffectedBuilder extends AssertionBuilder {
   @Override
   public Assertion build() {
      return new UnaffectedAssertion();
   }
}
