package com.lexicalscope.supplant.supplantspecify.specification;

import com.lexicalscope.fluent.list.FluentList;

public class HeapMatch extends AbstractSpecificationElement {
   private final FluentList<HeapElementMatch> heapElementMatches;

   public HeapMatch(final FluentList<HeapElementMatch> heapElementMatches) {
      this.heapElementMatches = heapElementMatches;
   }
}
