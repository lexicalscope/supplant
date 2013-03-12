package com.lexicalscope.supplant.supplantspecify;

import static com.lexicalscope.supplant.supplantspecify.AddressMatchBuilder.*;
import static com.lexicalscope.supplant.supplantspecify.AssertionBuilder.*;
import static com.lexicalscope.supplant.supplantspecify.BindingBuilder.binding;
import static com.lexicalscope.supplant.supplantspecify.CongruenceBuilder.withCongruence;
import static com.lexicalscope.supplant.supplantspecify.HeapMatchBuilder.heapMatch;
import static com.lexicalscope.supplant.supplantspecify.LocationBuilder.location;
import static com.lexicalscope.supplant.supplantspecify.ObjectMatchBuilder.objectWithType;
import static com.lexicalscope.supplant.supplantspecify.ObjectReplacementBuilder.noObject;
import static com.lexicalscope.supplant.supplantspecify.SnapshotMatchBuilder.*;
import static com.lexicalscope.supplant.supplantspecify.SnapshotTransformBuilder.snapshotTransform;
import static com.lexicalscope.supplant.supplantspecify.SpecificationBuilder.specification;

import org.junit.Test;

public class TestSpecificationGrammar extends AbstractTestSpecification {
   @Test
   public void testRefactoring() {
      assertSpecification(
            "result ( unaffected )",
            specification(withCongruence("result")).withAssertion(unaffected()));
   }

   @Test
   public void testProtocolResult() {
      parseSpecification(
          "protocol([<this>->{PageGeneration}])" +
          "( \n" +
          "   <meth->\"generate\">[<x>->{PageRequest, uri=\"/poi\"}] \n" +
          "  => _ \n" +
          "  => @r [<w>->{Page}:p] \n" +
          ") \n" +
          "(@r.old [<w>->p{content=\"newcontent\"}])\n");
   }

   @Test
   public void testResultTransformedToNull() {
      assertSpecification("result([*] => @r [*:a->{Page}])(@r [a->])",
            specification(withCongruence("result")).
               withAssertion(
                     twoTupleMatch(
                           wildcard(),
                           newSnapshotMatch(location("r"),
                                            heapMatch(bindingWildcardAddress(binding("a")), objectWithType("Page"))),
                     snapshotTransform(matchBoundAddress("a"), noObject()))));
   }
}