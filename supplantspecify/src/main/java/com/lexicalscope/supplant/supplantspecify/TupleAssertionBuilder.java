package com.lexicalscope.supplant.supplantspecify;

import static com.lexicalscope.fluent.FluentDollar.$;
import static com.lexicalscope.supplant.supplantspecify.ConverterBuild.buildAs;

import java.util.ArrayList;
import java.util.List;

import com.lexicalscope.supplant.supplantspecify.specification.Assertion;
import com.lexicalscope.supplant.supplantspecify.specification.TupleAssertion;

public class TupleAssertionBuilder extends AssertionBuilder {
   private final List<SpecificationElementBuilder<SnapshotMatcher>> matchers = new ArrayList<>();

   @Override
   public Assertion build() {
      return new TupleAssertion($(matchers)._convert(buildAs(SnapshotMatcher.class)));
   }

   public TupleAssertionBuilder withMatcher(final SnapshotMatchBuilder snapshotMatcher) {
      matchers.add(snapshotMatcher);
      return this;
   }
}
