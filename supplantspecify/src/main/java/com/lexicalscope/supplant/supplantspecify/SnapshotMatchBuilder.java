package com.lexicalscope.supplant.supplantspecify;

import static com.lexicalscope.supplant.supplantspecify.AddressMatchBuilder.wildcardAddress;
import static com.lexicalscope.supplant.supplantspecify.HeapMatchBuilder.heapMatch;

import com.lexicalscope.supplant.supplantspecify.specification.SnapshotMatch;


public class SnapshotMatchBuilder implements SpecificationElementBuilder<SnapshotMatch>  {
   private HeapMatchBuilder heapMatch;
   private LocationBuilder location;
   private StackMatchBuilder stackMatch;

   public static SnapshotMatchBuilder wildcard() {
      return newSnapshotMatch().withHeapMatch(heapMatch().with(wildcardAddress()));
   }

   private SnapshotMatchBuilder withHeapMatch(final HeapMatchBuilder heapMatch) {
      this.heapMatch = heapMatch;
      return this;
   }

   public static SnapshotMatchBuilder newSnapshotMatch() {
      return new SnapshotMatchBuilder();
   }

   public static SnapshotMatchBuilder newSnapshotMatch(final HeapMatchBuilder heapMatch) {
      return newSnapshotMatch().with(heapMatch);
   }

   public static SnapshotMatchBuilder newSnapshotMatch(final LocationBuilder location, final HeapMatchBuilder heapMatch) {
      return newSnapshotMatch().with(location).with(heapMatch);
   }

   @Override
   public SnapshotMatch build() {
      return new SnapshotMatch(
            location != null ? location.build() : null,
            heapMatch != null ? heapMatch.build() : null,
            stackMatch != null ? stackMatch.build() : null);
   }

   public SnapshotMatchBuilder with(final HeapMatchBuilder heapMatch) {
      this.heapMatch = heapMatch;
      return this;
   }

   public SnapshotMatchBuilder with(final LocationBuilder location) {
      this.location = location;
      return this;
   }

   public SnapshotMatchBuilder with(final StackMatchBuilder stackMatch) {
      this.stackMatch = stackMatch;
      return this;
   }
}
