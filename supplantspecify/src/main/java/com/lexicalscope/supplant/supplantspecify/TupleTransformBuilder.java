package com.lexicalscope.supplant.supplantspecify;

import static com.lexicalscope.fluent.FluentDollar.$;
import static com.lexicalscope.supplant.supplantspecify.ConverterBuild.buildAs;

import java.util.ArrayList;
import java.util.List;

import com.lexicalscope.supplant.supplantspecify.specification.SnapshotTransform;
import com.lexicalscope.supplant.supplantspecify.specification.TupleTransform;

public class TupleTransformBuilder implements SpecificationElementBuilder<TupleTransform> {
   private final List<SpecificationElementBuilder<SnapshotTransform>> transforms = new ArrayList<>();

   public TupleTransformBuilder with(final SnapshotTransformBuilder snapshotTransformBuilder) {
      transforms.add(snapshotTransformBuilder);
      return this;
   }

   public static TupleTransformBuilder tupleTransform() {
      return new TupleTransformBuilder();
   }

   @Override
   public TupleTransform build() {
      return new TupleTransform($(transforms)._convert(buildAs(SnapshotTransform.class)));
   }
}
