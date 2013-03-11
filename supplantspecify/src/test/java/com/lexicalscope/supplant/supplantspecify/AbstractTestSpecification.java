package com.lexicalscope.supplant.supplantspecify;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.lexicalscope.supplant.supplantspecify.specification.Congruence;
import com.lexicalscope.supplant.supplantspecify.specification.SnapshotMatch;
import com.lexicalscope.supplant.supplantspecify.specification.Specification;

public abstract class AbstractTestSpecification {
   public static void assertSpecification(final String string, final SpecificationBuilder matcher) {
      assertTreeMatchesInternalDsl(parseSpecification(string), matcher);
   }

   public static void assertCongruence(final String example, final CongruenceBuilder matcher) {
      assertTreeMatchesInternalDsl(parseCongruence(example), matcher);
   }

   public static void assertSnapshotMatch(final String example, final SnapshotMatchBuilder matcher) {
      assertTreeMatchesInternalDsl(parseSnapshotMath(example), matcher);
   }

   private static void assertTreeMatchesInternalDsl(final Object tree, final SpecificationElementBuilder<?> builder) {
      assertThat(tree, equalTo((Object) builder.build()));
   }

   public static Specification parseSpecification(final String example) {
      return walkTree(parse(example).specification()).specification();
   }

   public static Congruence parseCongruence(final String example) {
      return walkTree(parse(example).congruence()).congruence();
   }

   public static SnapshotMatch parseSnapshotMath(final String example) {
      return walkTree(parse(example).snapshotMatch()).snapshotMatch();
   }

   public static  SupplantSpecifyParser parse(final String example) {
      final SupplantSpecifyLexer lexer = new SupplantSpecifyLexer(new ANTLRInputStream(example));
      final SupplantSpecifyParser parser = new SupplantSpecifyParser(new CommonTokenStream(lexer));
      parser.addErrorListener(new ConsoleErrorListener());
//      parser.setErrorHandler(new BailErrorStrategy());
      return parser;
   }

   public static SpecificationBuildingListener walkTree(final ParseTree tree) {
      final SpecificationBuildingListener specificationBuildingListener = new SpecificationBuildingListener();
      ParseTreeWalker.DEFAULT.walk(specificationBuildingListener, tree);
      return specificationBuildingListener;
   }
}
