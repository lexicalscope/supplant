package com.lexicalscope.supplant.supplantspecify.specification;


public class SnapshotMatch extends AbstractSpecificationElement {
   private final HeapMatch heapMatch;

   public SnapshotMatch(final HeapMatch heapMatch) {
      this.heapMatch = heapMatch;
   }
}
