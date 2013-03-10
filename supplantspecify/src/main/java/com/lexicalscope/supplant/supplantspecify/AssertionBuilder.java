package com.lexicalscope.supplant.supplantspecify;

import static com.lexicalscope.supplant.supplantspecify.TupleAssertionBuilder.tupleAssertion;
import static com.lexicalscope.supplant.supplantspecify.TupleMatchBuilder.tupleMatch;

import com.lexicalscope.supplant.supplantspecify.specification.Assertion;

public abstract class AssertionBuilder implements SpecificationElementBuilder<Assertion> {
   public static AssertionBuilder unaffected() {
      return new AssertionUnnaffectedBuilder();
   }

   @Override
   public abstract Assertion build();

   public static AssertionBuilder twoTupleMatch(
         final SnapshotMatchBuilder first,
         final SnapshotMatchBuilder second,
         final SnapshotTransformBuilder snapshotTransformBuilder) {
      return tupleAssertion(tupleMatch().with(first).with(second), TupleTransformBuilder.tupleTransform().with(snapshotTransformBuilder));
   }
}
