package com.lexicalscope.supplant.supplantspecify.specification;

import com.lexicalscope.fluent.list.FluentList;
import com.lexicalscope.supplant.supplantspecify.SnapshotMatcher;


public class TupleAssertion extends Assertion {
   private final FluentList<SnapshotMatcher> matchers;

   public TupleAssertion(final FluentList<SnapshotMatcher> matchers) {
      this.matchers = matchers;
   }
}
