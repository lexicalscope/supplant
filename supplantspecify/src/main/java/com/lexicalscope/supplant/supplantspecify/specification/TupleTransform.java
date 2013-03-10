package com.lexicalscope.supplant.supplantspecify.specification;

import com.lexicalscope.fluent.list.FluentList;

public class TupleTransform extends AbstractSpecificationElement {
   private final FluentList<SnapshotTransform> snapshotTransforms;

   public TupleTransform(final FluentList<SnapshotTransform> snapshotTransforms) {
      this.snapshotTransforms = snapshotTransforms;
   }
}
