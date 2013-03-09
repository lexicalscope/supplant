package com.lexicalscope.supplant.supplantspecify.specification;

public class Specification extends AbstractSpecificationElement {
   private final Congruence congruence;
   private final Assertion assertion;

   public Specification(final Congruence congruence, final Assertion assertion) {
      this.congruence = congruence;
      this.assertion = assertion;
   }
}
