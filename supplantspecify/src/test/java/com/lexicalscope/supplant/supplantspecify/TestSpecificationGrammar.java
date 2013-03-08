package com.lexicalscope.supplant.supplantspecify;

import static org.hamcrest.MatcherAssert.assertThat;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.junit.Test;

import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.SpecificationContext;

public class TestSpecificationGrammar {
   @Test public void testRefactoring() {
      assertSpecification("result { unaffected }", congruence("result"));//.and(assertsUnafected()));
   }

   private void assertSpecification(final String string, final Matcher<SpecificationContext> matcher) {
      assertThat(parse(string), matcher);
   }

   private Matcher<SpecificationContext> congruence(final String identifier) {
      return new TypeSafeDiagnosingMatcher<SpecificationContext>(){
         @Override
         public void describeTo(final Description description) {
            description.appendText("a specification using congruence ").appendValue(identifier);
         }

         @Override
         protected boolean matchesSafely(final SpecificationContext item, final Description mismatchDescription) {
            final String identifer = item.congruence().Identifier().getText();
            if(identifer.equals(identifier))
            {
               return true;
            }
            mismatchDescription.appendText("wrong identifier " + identifer);
            return false;
         }};
   }

   private SpecificationContext parse(final String example) {
      final SupplantSpecifyLexer lexer = new SupplantSpecifyLexer(new ANTLRInputStream(example));
      final SupplantSpecifyParser parser = new SupplantSpecifyParser(new CommonTokenStream(lexer));
      final SpecificationContext tree = parser.specification();
      //ParseTreeWalker.DEFAULT.walk(new SpecificationTestListener(), tree);
      return tree;
   }
}