package com.lexicalscope.supplant.supplantspecify;

import static com.lexicalscope.supplant.supplantspecify.HeapTransformBuilder.heapTransform;

import com.lexicalscope.supplant.supplantspecify.specification.SnapshotTransform;

public class SnapshotTransformBuilder implements SpecificationElementBuilder<SnapshotTransform> {
   private HeapTransformBuilder heapTransform;

   public static SnapshotTransformBuilder snapshotTransform() {
      return new SnapshotTransformBuilder();
   }

   @Override
   public SnapshotTransform build() {
      return new SnapshotTransform(heapTransform != null ? heapTransform.build(): null);
   }

   public static SnapshotTransformBuilder snapshotTransform(final AddressMatchBuilder addressMatch, final ObjectReplacementBuilder objectReplacement) {
      return snapshotTransform().with(heapTransform(addressMatch, objectReplacement));
   }

   SnapshotTransformBuilder with(final HeapTransformBuilder heapTransform) {
      this.heapTransform = heapTransform;
      return this;
   }
}
