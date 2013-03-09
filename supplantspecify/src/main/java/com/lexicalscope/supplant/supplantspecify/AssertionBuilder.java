package com.lexicalscope.supplant.supplantspecify;

import com.lexicalscope.supplant.supplantspecify.specification.Assertion;

public abstract class AssertionBuilder implements SpecificationElementBuilder<Assertion> {
   public static AssertionBuilder unaffected() {
      return new AssertionUnnaffectedBuilder();
   }

   @Override
   public abstract Assertion build();

   public static AssertionBuilder twoTuple(final SnapshotMatchBuilder first, final SnapshotMatchBuilder second) {
      return new TupleAssertionBuilder().withMatcher(first).withMatcher(second);
   }
}
