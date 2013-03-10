package com.lexicalscope.supplant.supplantspecify.specification;




public class TupleAssertion extends Assertion {
   private final TupleMatch tupleMatch;
   private final TupleTransform tupleTransformBuilder;

   public TupleAssertion(final TupleMatch tupleMatch, final TupleTransform tupleTransformBuilder) {
      this.tupleMatch = tupleMatch;
      this.tupleTransformBuilder = tupleTransformBuilder;
   }
}
