package com.lexicalscope.supplant.supplantspecify;

import com.lexicalscope.supplant.supplantspecify.specification.Congruence;

public class CongruenceBuilder implements SpecificationElementBuilder<Congruence>  {
   private final String name;
   private SnapshotMatchBuilder snapshotMatch;

   public CongruenceBuilder(final String name) {
      this.name = name;
   }

   public static CongruenceBuilder withCongruence(final String name) {
      return new CongruenceBuilder(name);
   }

   @Override
   public Congruence build() {
      return new Congruence(name, snapshotMatch != null ? snapshotMatch.build() : null);
   }

   public CongruenceBuilder when(final SnapshotMatchBuilder snapshotMatch) {
      this.snapshotMatch = snapshotMatch;
      return this;
   }
}
