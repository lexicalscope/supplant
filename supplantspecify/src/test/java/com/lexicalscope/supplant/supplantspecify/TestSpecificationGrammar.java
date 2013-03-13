package com.lexicalscope.supplant.supplantspecify;


public class TestSpecificationGrammar extends AbstractTestSpecification {
//   @Test
//   public void testRefactoring() {
//      assertSpecification(
//            "result ( unaffected )",
//            specification(withCongruence("result")).withAssertion(unaffected()));
//   }
//
//   @Test
//   public void testProtocolResult() {
//      parseSpecification(
//          "protocol([<this>->{PageGeneration}])" +
//          "( \n" +
//          "   <meth->\"generate\">[<x>->{PageRequest, uri=\"/poi\"}] \n" +
//          "  => _ \n" +
//          "  => @r [<w>->{Page}:p] \n" +
//          ") \n" +
//          "(@r.old [<w>->p{content=\"newcontent\"}])\n");
//
//      parseSpecification(
//            "result([*] => @r [*:a->{Page}])(@r [a->])"
//            );
//   }
//
//   @Test
//   public void testResultTransformedToNull() {
//      assertSpecification("result([*] => @r [*:a->{Page}])(@r [a->])",
//            specification(withCongruence("result")).
//               withAssertion(
//                     twoTupleMatch(
//                           wildcard(),
//                           newSnapshotMatch(location("r"),
//                                            heapMatch(bindingWildcardAddress(binding("a")), objectWithType("Page"))),
//                     snapshotTransform(matchBoundAddress("a"), noObject()))));
//   }
}