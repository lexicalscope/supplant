package com.lexicalscope.supplant.supplantspecify;

import static com.lexicalscope.supplant.supplantspecify.AssertionBuilder.unaffected;
import static com.lexicalscope.supplant.supplantspecify.CongruenceBuilder.withCongruence;
import static com.lexicalscope.supplant.supplantspecify.SpecificationBuilder.specification;
import static com.lexicalscope.supplant.supplantspecify.SnapshotMatchBuilder.wildcard;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.SpecificationContext;
import com.lexicalscope.supplant.supplantspecify.specification.Specification;

public class TestSpecificationGrammar {
   @Test
   public void testRefactoring() {
      assertSpecification(
            "result { unaffected }",
            specification(withCongruence("result")).withAssertion(unaffected()));
   }

   @Test
   public void testResultTransformedToNull() {
      assertSpecification("result { * => @r [*:a->object Page] then @r [a->null]}",
            specification(withCongruence("result")).
               withAssertion(AssertionBuilder.twoTuple(wildcard(), wildcard())));
   }


   private void assertSpecification(final String string, final SpecificationBuilder matcher) {
      assertThat(parse(string), equalTo(matcher.build()));
   }

   private Specification parse(final String example) {
      final SupplantSpecifyLexer lexer = new SupplantSpecifyLexer(new ANTLRInputStream(example));
      final SupplantSpecifyParser parser = new SupplantSpecifyParser(new CommonTokenStream(lexer));
      final SpecificationContext tree = parser.specification();
      final SpecificationBuildingListener specificationBuildingListener = new SpecificationBuildingListener();
      ParseTreeWalker.DEFAULT.walk(specificationBuildingListener, tree);
      return specificationBuildingListener.specification();
   }
}