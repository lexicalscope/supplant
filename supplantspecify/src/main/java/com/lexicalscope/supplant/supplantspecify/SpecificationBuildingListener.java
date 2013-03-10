package com.lexicalscope.supplant.supplantspecify;

import static com.lexicalscope.supplant.supplantspecify.AddressMatchBuilder.wildcardAddress;
import static com.lexicalscope.supplant.supplantspecify.AssertionBuilder.unaffected;
import static com.lexicalscope.supplant.supplantspecify.BindingBuilder.binding;
import static com.lexicalscope.supplant.supplantspecify.CongruenceBuilder.withCongruence;
import static com.lexicalscope.supplant.supplantspecify.HeapElementMatchBuilder.heapElementMatch;
import static com.lexicalscope.supplant.supplantspecify.HeapMatchBuilder.heapMatch;
import static com.lexicalscope.supplant.supplantspecify.HeapTransformBuilder.heapTransform;
import static com.lexicalscope.supplant.supplantspecify.ObjectMatchBuilder.objectMatch;
import static com.lexicalscope.supplant.supplantspecify.SnapshotMatchBuilder.snapshotMatch;
import static com.lexicalscope.supplant.supplantspecify.SnapshotTransformBuilder.snapshotTransform;
import static com.lexicalscope.supplant.supplantspecify.TupleAssertionBuilder.tupleAssertion;
import static com.lexicalscope.supplant.supplantspecify.TupleTransformBuilder.tupleTransform;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.BindingContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.BoundAddressMatchContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.CongruenceContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.HeapElementMatchContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.HeapMatchContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.HeapTransformContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.LocationContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.ObjectMatchContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.SnapshotMatchContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.SnapshotTransformContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.SpecificationContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.StackMatchContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.TupleAssertionContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.TupleMatchContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.TupleTransformContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.UnaffectedAssertionContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.WildcardAddressMatchContext;
import com.lexicalscope.supplant.supplantspecify.specification.Specification;

public class SpecificationBuildingListener implements SupplantSpecifyListener {
   private SpecificationBuilder result;
   private TupleAssertionBuilder tupleAssertion;
   private TupleMatchBuilder tupleMatch;
   private HeapMatchBuilder heapMatch;
   private SnapshotMatchBuilder snapshotMatch;
   private SnapshotTransformBuilder snapshotTransform;
   private TupleTransformBuilder tupleTransform;
   private CongruenceBuilder congruence;
   private LocationBuilder location;
   private ObjectMatchBuilder objectMatch;
   private HeapTransformBuilder heapTransform;
   private HeapElementMatchBuilder heapElementMatch;
   private BindingBuilder binding;
   private AddressMatchBuilder addressMatch;

   public Specification specification() {
      return result.build();
   }

   @Override
   public void visitTerminal(@SuppressWarnings("unused") final TerminalNode node) { }

   @Override
   public void visitErrorNode(@SuppressWarnings("unused") final ErrorNode node) { }

   @Override
   public void enterEveryRule(@SuppressWarnings("unused") final ParserRuleContext ctx) { }

   @Override
   public void exitEveryRule(@SuppressWarnings("unused") final ParserRuleContext ctx) { }

   @Override
   public void enterCongruence(final CongruenceContext ctx) {
      congruence = withCongruence(ctx.Identifier().getText());
   }

   @Override
   public void exitCongruence(@SuppressWarnings("unused") final CongruenceContext ctx) {
      result.withCongruence(congruence);
   }

   @Override
   public void enterTupleMatch(@SuppressWarnings("unused") final TupleMatchContext ctx) {
      tupleMatch = new TupleMatchBuilder();
   }

   @Override
   public void exitTupleMatch(@SuppressWarnings("unused") final TupleMatchContext ctx) {
      tupleAssertion.withTupleMatch(tupleMatch);
   }

   @Override
   public void enterUnaffectedAssertion(@SuppressWarnings("unused") final UnaffectedAssertionContext ctx) {
      // nothing
   }

   @Override
   public void exitUnaffectedAssertion(@SuppressWarnings("unused") final UnaffectedAssertionContext ctx) {
      result.withAssertion(unaffected());
   }

   @Override
   public void enterSpecification(@SuppressWarnings("unused") final SpecificationContext ctx) {
      result = new SpecificationBuilder();
   }

   @Override
   public void exitSpecification(@SuppressWarnings("unused") final SpecificationContext ctx) {
      // nothing
   }

   @Override
   public void enterLocation(final LocationContext ctx) {
      location = LocationBuilder.location(ctx.Identifier().getText());
   }

   @Override
   public void exitLocation(@SuppressWarnings("unused") final LocationContext ctx) {
      if(snapshotMatch != null)
         snapshotMatch.with(location);
   }

   @Override
   public void enterStackMatch(final StackMatchContext ctx) {
      // TODO Auto-generated method stub
   }

   @Override
   public void exitStackMatch(final StackMatchContext ctx) {
      // TODO Auto-generated method stub
   }

   @Override
   public void enterSnapshotMatch(@SuppressWarnings("unused") final SnapshotMatchContext ctx) {
      snapshotMatch = snapshotMatch();
   }

   @Override
   public void exitSnapshotMatch(@SuppressWarnings("unused") final SnapshotMatchContext ctx) {
      tupleMatch.with(snapshotMatch);
      snapshotMatch = null;
   }

   @Override
   public void enterHeapMatch(@SuppressWarnings("unused") final HeapMatchContext ctx) {
      heapMatch = heapMatch();
   }

   @Override
   public void exitHeapMatch(@SuppressWarnings("unused") final HeapMatchContext ctx) {
      snapshotMatch.with(heapMatch);
      heapMatch = null;
   }

   @Override
   public void enterTupleAssertion(@SuppressWarnings("unused") final TupleAssertionContext ctx) {
      tupleAssertion = tupleAssertion();
   }

   @Override
   public void exitTupleAssertion(@SuppressWarnings("unused") final TupleAssertionContext ctx) {
      result.withAssertion(tupleAssertion);
      tupleAssertion = null;
   }

   @Override
   public void enterSnapshotTransform(@SuppressWarnings("unused") final SnapshotTransformContext ctx) {
      snapshotTransform = snapshotTransform();
   }

   @Override
   public void exitSnapshotTransform(@SuppressWarnings("unused") final SnapshotTransformContext ctx) {
      tupleTransform.with(snapshotTransform);
      snapshotTransform = null;
   }

   @Override
   public void enterHeapTransform(@SuppressWarnings("unused") final HeapTransformContext ctx) {
      heapTransform = heapTransform();
   }

   @Override
   public void exitHeapTransform(@SuppressWarnings("unused") final HeapTransformContext ctx) {
      heapTransform.with(addressMatch);

      snapshotTransform.with(heapTransform);
      heapTransform = null;
   }

   @Override
   public void enterTupleTransform(@SuppressWarnings("unused") final TupleTransformContext ctx) {
      tupleTransform = tupleTransform();
   }

   @Override
   public void exitTupleTransform(@SuppressWarnings("unused") final TupleTransformContext ctx) {
      tupleAssertion.withTupleTransform(tupleTransform);
   }

   @Override
   public void enterObjectMatch(final ObjectMatchContext ctx) {
      objectMatch = objectMatch().withType(ctx.Identifier().getText());

   }

   @Override
   public void exitObjectMatch(@SuppressWarnings("unused") final ObjectMatchContext ctx) {
      heapElementMatch.with(objectMatch);
      objectMatch = null;
   }

   @Override
   public void enterBinding(final BindingContext ctx) {
      addressMatch.bindTo(binding(ctx.Identifier().getText()));
   }

   @Override
   public void exitBinding(@SuppressWarnings("unused") final BindingContext ctx) {

   }

   @Override
   public void enterHeapElementMatch(@SuppressWarnings("unused") final HeapElementMatchContext ctx) {
      heapElementMatch = heapElementMatch();
   }

   @Override
   public void exitHeapElementMatch(@SuppressWarnings("unused") final HeapElementMatchContext ctx) {
      heapElementMatch.with(addressMatch);
      addressMatch = null;

      heapMatch.with(heapElementMatch);
      heapElementMatch = null;
   }

   @Override
   public void enterWildcardAddressMatch(@SuppressWarnings("unused") final WildcardAddressMatchContext ctx) {
      addressMatch = wildcardAddress();
   }

   @Override
   public void exitWildcardAddressMatch(@SuppressWarnings("unused") final WildcardAddressMatchContext ctx) {
      // nothing
   }

   @Override
   public void enterBoundAddressMatch(final BoundAddressMatchContext ctx) {
      addressMatch = AddressMatchBuilder.matchBoundAddress(ctx.Identifier().getText());
   }

   @Override
   public void exitBoundAddressMatch(@SuppressWarnings("unused") final BoundAddressMatchContext ctx) {
     // nothing
   }
}
