package com.lexicalscope.supplant.supplantspecify;

import com.lexicalscope.supplant.supplantspecify.specification.Assertion;
import com.lexicalscope.supplant.supplantspecify.specification.TupleAssertion;


public class TupleAssertionBuilder extends AssertionBuilder {
   private TupleMatchBuilder tupleMatch;
   private TupleTransformBuilder tupleTransform;

   public static TupleAssertionBuilder tupleAssertion() {
      return new TupleAssertionBuilder();
   }

   public TupleAssertionBuilder withTupleMatch(final TupleMatchBuilder tupleMatch) {
      this.tupleMatch = tupleMatch;
      return this;
   }

   @Override
   public Assertion build() {
      return new TupleAssertion(
                  tupleMatch != null ? tupleMatch.build() : null,
                  tupleTransform != null ? tupleTransform.build() : null);
   }

   public static TupleAssertionBuilder tupleAssertion(final TupleMatchBuilder tupleMatch, final TupleTransformBuilder tupleTransform) {
      return new TupleAssertionBuilder().withTupleMatch(tupleMatch).withTupleTransform(tupleTransform);
   }

   public TupleAssertionBuilder withTupleTransform(final TupleTransformBuilder tupleTransform) {
      this.tupleTransform = tupleTransform;
      return this;
   }
}
