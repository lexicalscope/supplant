package com.lexicalscope.supplant.supplantspecify;

import static com.lexicalscope.supplant.supplantspecify.CongruenceBuilder.withCongruence;
import static com.lexicalscope.supplant.supplantspecify.ObjectMatchBuilder.objectWithType;
import static com.lexicalscope.supplant.supplantspecify.SnapshotMatchBuilder.newSnapshotMatch;
import static com.lexicalscope.supplant.supplantspecify.StackMatchBuilder.stackMatch;
import static com.lexicalscope.supplant.supplantspecify.TestSpecificationGrammar.assertCongruence;
import static com.lexicalscope.supplant.supplantspecify.VariableMatchBuilder.variableMatch;

import org.junit.Test;

public class TestCongruence {
   @Test
   public void testCongruenceWithStackMatch() {
      assertCongruence("protocol(<this->{MyType}>)",
            withCongruence("protocol").when(
                  newSnapshotMatch().with(stackMatch(variableMatch("this"), objectWithType("MyType")))));
   }
}
