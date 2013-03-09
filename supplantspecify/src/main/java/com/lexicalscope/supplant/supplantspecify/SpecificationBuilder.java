package com.lexicalscope.supplant.supplantspecify;

import com.lexicalscope.supplant.supplantspecify.specification.Specification;

public class SpecificationBuilder {
   private CongruenceBuilder congruence;
   private AssertionBuilder assertion;

   SpecificationBuilder withCongruence(final CongruenceBuilder congruence) {
      this.congruence = congruence;
      return this;
   }

   public Specification build() {
      return new Specification(
            congruence != null ? congruence.build() : null,
            assertion != null ? assertion.build() : null);
   }

   public static SpecificationBuilder specification(final CongruenceBuilder congruence) {
      return new SpecificationBuilder().withCongruence(congruence);
   }

   public SpecificationBuilder withAssertion(final AssertionBuilder assertion) {
      this.assertion = assertion;
      return this;
   }
}
