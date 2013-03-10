package com.lexicalscope.supplant.supplantspecify.specification;

import com.lexicalscope.fluent.list.FluentList;

public class TupleMatch extends AbstractSpecificationElement {
   private final FluentList<SnapshotMatch> matchers;

   public TupleMatch(final FluentList<SnapshotMatch> matchers) {
      this.matchers = matchers;
   }
}
