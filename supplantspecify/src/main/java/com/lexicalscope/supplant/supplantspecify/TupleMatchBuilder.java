package com.lexicalscope.supplant.supplantspecify;

import static com.lexicalscope.fluent.FluentDollar.$;
import static com.lexicalscope.supplant.supplantspecify.ConverterBuild.buildAs;

import java.util.ArrayList;
import java.util.List;

import com.lexicalscope.supplant.supplantspecify.specification.AbstractSpecificationElement;
import com.lexicalscope.supplant.supplantspecify.specification.SnapshotMatch;
import com.lexicalscope.supplant.supplantspecify.specification.TupleMatch;

public class TupleMatchBuilder extends AbstractSpecificationElement implements SpecificationElementBuilder<TupleMatch>  {
   private final List<SpecificationElementBuilder<SnapshotMatch>> matchers = new ArrayList<>();

   @Override
   public TupleMatch build() {
      return new TupleMatch($(matchers)._convert(buildAs(SnapshotMatch.class)));
   }

   public TupleMatchBuilder with(final SnapshotMatchBuilder snapshotMatcher) {
      if(snapshotMatcher != null) {matchers.add(snapshotMatcher);};
      return this;
   }

   public static TupleMatchBuilder tupleMatch() {
      return new TupleMatchBuilder();
   }
}
