package com.lexicalscope.supplant.supplantspecify.specification;

public class SnapshotTransform extends AbstractSpecificationElement {
   private final HeapTransform heapTransform;

   public SnapshotTransform(final HeapTransform heapTransform) {
      this.heapTransform = heapTransform;
   }
}
