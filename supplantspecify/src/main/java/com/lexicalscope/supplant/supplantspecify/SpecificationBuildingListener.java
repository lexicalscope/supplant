package com.lexicalscope.supplant.supplantspecify;

import static com.lexicalscope.supplant.supplantspecify.AssertionBuilder.unaffected;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.ActionContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.ActionsContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.CongruenceContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.MatchAssertionContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.MatchContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.SpecificationContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.TuplematchContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.UnaffectedContext;
import com.lexicalscope.supplant.supplantspecify.specification.Specification;

public class SpecificationBuildingListener implements SupplantSpecifyListener {
   private final SpecificationBuilder result = new SpecificationBuilder();

   public Specification specification() {
      return result.build();
   }

   @Override
   public void visitTerminal(final TerminalNode node) {
      // TODO Auto-generated method stub

   }

   @Override
   public void visitErrorNode(final ErrorNode node) {
      // TODO Auto-generated method stub

   }

   @Override
   public void enterEveryRule(final ParserRuleContext ctx) {
      // TODO Auto-generated method stub

   }

   @Override
   public void exitEveryRule(final ParserRuleContext ctx) {
      // TODO Auto-generated method stub

   }

   @Override
   public void enterCongruence(final CongruenceContext ctx) {
      result.withCongruence(CongruenceBuilder.withCongruence(ctx.Identifier().getText()));

   }

   @Override
   public void exitCongruence(final CongruenceContext ctx) {
      // TODO Auto-generated method stub

   }

   @Override
   public void enterTuplematch(final TuplematchContext ctx) {
      // TODO Auto-generated method stub

   }

   @Override
   public void exitTuplematch(final TuplematchContext ctx) {
      // TODO Auto-generated method stub

   }

   @Override
   public void enterUnaffected(final UnaffectedContext ctx) {
      result.withAssertion(unaffected());

   }

   @Override
   public void exitUnaffected(final UnaffectedContext ctx) {
      // TODO Auto-generated method stub

   }

   @Override
   public void enterAction(final ActionContext ctx) {
      // TODO Auto-generated method stub

   }

   @Override
   public void exitAction(final ActionContext ctx) {
      // TODO Auto-generated method stub

   }

   @Override
   public void enterSpecification(final SpecificationContext ctx) {
      // TODO Auto-generated method stub

   }

   @Override
   public void exitSpecification(final SpecificationContext ctx) {
      // TODO Auto-generated method stub

   }

   @Override
   public void enterMatch(final MatchContext ctx) {
      // TODO Auto-generated method stub

   }

   @Override
   public void exitMatch(final MatchContext ctx) {
      // TODO Auto-generated method stub

   }

   @Override
   public void enterActions(final ActionsContext ctx) {
      // TODO Auto-generated method stub

   }

   @Override
   public void exitActions(final ActionsContext ctx) {
      // TODO Auto-generated method stub

   }

   @Override
   public void enterMatchAssertion(final MatchAssertionContext ctx) {
      // TODO Auto-generated method stub

   }

   @Override
   public void exitMatchAssertion(final MatchAssertionContext ctx) {
      // TODO Auto-generated method stub

   }
}
