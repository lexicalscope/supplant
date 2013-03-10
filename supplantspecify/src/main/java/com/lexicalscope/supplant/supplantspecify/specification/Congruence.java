package com.lexicalscope.supplant.supplantspecify.specification;

public class Congruence extends AbstractSpecificationElement {
   private final String name;
   private final SnapshotMatch snapshotMatch;

   public Congruence(final String name, final SnapshotMatch snapshotMatch) {
      this.name = name;
      this.snapshotMatch = snapshotMatch;
   }
}
