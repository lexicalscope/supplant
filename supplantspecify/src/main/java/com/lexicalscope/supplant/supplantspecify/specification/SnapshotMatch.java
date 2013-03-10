package com.lexicalscope.supplant.supplantspecify.specification;


public class SnapshotMatch extends AbstractSpecificationElement {
   private final Location location;
   private final HeapMatch heapMatch;
   private final StackMatch stackMatch;

   public SnapshotMatch(
         final Location location,
         final HeapMatch heapMatch,
         final StackMatch stackMatch) {
      this.location = location;
      this.heapMatch = heapMatch;
      this.stackMatch = stackMatch;
   }
}
