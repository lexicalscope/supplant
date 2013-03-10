package com.lexicalscope.supplant.supplantspecify;

import static com.lexicalscope.supplant.supplantspecify.AddressMatchBuilder.wildcardAddress;
import static com.lexicalscope.supplant.supplantspecify.HeapMatchBuilder.heapMatch;

import com.lexicalscope.supplant.supplantspecify.specification.SnapshotMatch;


public class SnapshotMatchBuilder implements SpecificationElementBuilder<SnapshotMatch>  {
   private HeapMatchBuilder heapMatch;
   private LocationBuilder location;

   public static SnapshotMatchBuilder wildcard() {
      return snapshotMatch().withHeapMatch(heapMatch().with(wildcardAddress()));
   }

   private SnapshotMatchBuilder withHeapMatch(final HeapMatchBuilder heapMatch) {
      this.heapMatch = heapMatch;
      return this;
   }

   public static SnapshotMatchBuilder snapshotMatch() {
      return new SnapshotMatchBuilder();
   }

   @Override
   public SnapshotMatch build() {
      return new SnapshotMatch(heapMatch != null ? heapMatch.build() : null);
   }

   public SnapshotMatchBuilder with(final HeapMatchBuilder heapMatch) {
      this.heapMatch = heapMatch;
      return this;
   }

   public SnapshotMatchBuilder with(final LocationBuilder location) {
      this.location = location;
      return this;
   }
}
