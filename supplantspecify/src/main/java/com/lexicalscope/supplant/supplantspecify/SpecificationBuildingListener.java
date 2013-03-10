package com.lexicalscope.supplant.supplantspecify;

import static com.lexicalscope.supplant.supplantspecify.AddressMatchBuilder.*;
import static com.lexicalscope.supplant.supplantspecify.AssertionBuilder.unaffected;
import static com.lexicalscope.supplant.supplantspecify.BindingBuilder.binding;
import static com.lexicalscope.supplant.supplantspecify.CongruenceBuilder.withCongruence;
import static com.lexicalscope.supplant.supplantspecify.HeapElementMatchBuilder.heapElementMatch;
import static com.lexicalscope.supplant.supplantspecify.HeapMatchBuilder.heapMatch;
import static com.lexicalscope.supplant.supplantspecify.HeapTransformBuilder.heapTransform;
import static com.lexicalscope.supplant.supplantspecify.ObjectMatchBuilder.objectMatch;
import static com.lexicalscope.supplant.supplantspecify.SnapshotMatchBuilder.newSnapshotMatch;
import static com.lexicalscope.supplant.supplantspecify.SnapshotTransformBuilder.snapshotTransform;
import static com.lexicalscope.supplant.supplantspecify.TupleAssertionBuilder.tupleAssertion;
import static com.lexicalscope.supplant.supplantspecify.TupleTransformBuilder.tupleTransform;
import static com.lexicalscope.supplant.supplantspecify.VariableMatchBuilder.variableMatch;

import java.util.ArrayList;
import java.util.List;

import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.BindingAddressMatchContext;
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
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.StackAddressMatchContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.StackMatchContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.TupleAssertionContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.TupleMatchContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.TupleTransformContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.UnaffectedAssertionContext;
import com.lexicalscope.supplant.supplantspecify.SupplantSpecifyParser.VariableMatchContext;
import com.lexicalscope.supplant.supplantspecify.specification.Congruence;
import com.lexicalscope.supplant.supplantspecify.specification.SnapshotMatch;
import com.lexicalscope.supplant.supplantspecify.specification.Specification;

public class SpecificationBuildingListener extends SupplantSpecifyBaseListener {
   private SpecificationBuilder result;
   private TupleMatchBuilder tupleMatch;
   private HeapMatchBuilder heapMatch;
   private final List<SnapshotMatchBuilder> snapshotMatches = new ArrayList<>();
   private final List<SnapshotTransformBuilder> snapshotTransforms = new ArrayList<>();
   private TupleTransformBuilder tupleTransform;
   private CongruenceBuilder congruence;
   private LocationBuilder location;
   private ObjectMatchBuilder objectMatch;
   private HeapTransformBuilder heapTransform;
   private final List<HeapElementMatchBuilder> heapElementMatches = new ArrayList<>();
   private AddressMatchBuilder addressMatch;
   private BindingBuilder binding;
   private VariableMatchBuilder variableMatch;
   private StackMatchBuilder stackMatch;
   private AssertionBuilder assertion;

   public Specification specification() {
      return result.build();
   }

   public Congruence congruence() {
      return congruence.build();
   }

   public SnapshotMatch snapshotMatch() {
      return snapshotMatches.get(0).build();
   }

   @Override
   public void exitCongruence(final CongruenceContext ctx) {
      congruence = withCongruence(ctx.Identifier().getText());
      if(!snapshotMatches.isEmpty())
      {
         congruence.when(snapshotMatches.get(0));
         snapshotMatches.clear();
      }
   }

   @Override
   public void exitTupleMatch(@SuppressWarnings("unused") final TupleMatchContext ctx) {
      tupleMatch = TupleMatchBuilder.tupleMatch();
      for(final SnapshotMatchBuilder snapshotMatch : snapshotMatches) {
         tupleMatch.with(snapshotMatch);
      }
      snapshotMatches.clear();
   }

   @Override
   public void exitUnaffectedAssertion(@SuppressWarnings("unused") final UnaffectedAssertionContext ctx) {
      assertion = unaffected();
   }

   @Override
   public void exitSpecification(@SuppressWarnings("unused") final SpecificationContext ctx) {
      result = new SpecificationBuilder();
      result.withCongruence(congruence);
      result.withAssertion(assertion);
      congruence = null;
   }

   @Override
   public void exitLocation(final LocationContext ctx) {
      location = LocationBuilder.location(ctx.Identifier().getText());
   }

   @Override
   public void exitStackMatch(@SuppressWarnings("unused") final StackMatchContext ctx) {
      stackMatch = StackMatchBuilder.stackMatch();

      stackMatch.with(variableMatch);
      variableMatch = null;

      stackMatch.with(objectMatch);
      objectMatch = null;
   }

   @Override
   public void exitSnapshotMatch(@SuppressWarnings("unused") final SnapshotMatchContext ctx) {
      snapshotMatches.add(
            newSnapshotMatch().
               with(location).
               with(stackMatch).
               with(heapMatch));
      location = null;
      stackMatch = null;
      heapMatch = null;
   }

   @Override
   public void exitHeapMatch(@SuppressWarnings("unused") final HeapMatchContext ctx) {
      heapMatch = heapMatch();

      for(final HeapElementMatchBuilder heapElementMatch : heapElementMatches)
      {
         heapMatch.with(heapElementMatch);
      }
      heapElementMatches.clear();
   }

   @Override
   public void exitTupleAssertion(@SuppressWarnings("unused") final TupleAssertionContext ctx) {
      assertion = tupleAssertion().withTupleMatch(tupleMatch).withTupleTransform(tupleTransform);
      tupleMatch = null;
      tupleTransform = null;
   }

   @Override
   public void exitSnapshotTransform(@SuppressWarnings("unused") final SnapshotTransformContext ctx) {
      snapshotTransforms.add(snapshotTransform().with(heapTransform));
      heapTransform = null;
   }

   @Override
   public void exitHeapTransform(@SuppressWarnings("unused") final HeapTransformContext ctx) {
      heapTransform = heapTransform().with(addressMatch);
      addressMatch = null;
   }

   @Override
   public void exitTupleTransform(@SuppressWarnings("unused") final TupleTransformContext ctx) {
      tupleTransform = tupleTransform();
      for (final SnapshotTransformBuilder snapshotTransform : snapshotTransforms) {
         tupleTransform.with(snapshotTransform);
      }
   }

   @Override
   public void exitObjectMatch(final ObjectMatchContext ctx) {
      objectMatch = objectMatch().withType(ctx.Identifier().getText());
   }

   @Override
   public void exitBinding(final BindingContext ctx) {
      binding = binding(ctx.Identifier().getText());
   }

   @Override
   public void exitHeapElementMatch(@SuppressWarnings("unused") final HeapElementMatchContext ctx) {
      final HeapElementMatchBuilder heapElementMatch = heapElementMatch();

      heapElementMatch.with(addressMatch);
      addressMatch = null;

      heapElementMatch.with(objectMatch);
      objectMatch = null;

      heapElementMatches.add(heapElementMatch);
   }

   @Override
   public void exitBindingAddressMatch(@SuppressWarnings("unused") final BindingAddressMatchContext ctx) {
      if(binding != null)
      {
         addressMatch = AddressMatchBuilder.bindingWildcardAddress(binding);
         binding = null;
      }
      else
      {
         addressMatch = AddressMatchBuilder.wildcardAddress();
      }
   }

   @Override
   public void exitBoundAddressMatch(final BoundAddressMatchContext ctx) {
      addressMatch = matchBoundAddress(ctx.Identifier().getText());
   }

   @Override
   public void exitVariableMatch(final VariableMatchContext ctx) {
      variableMatch = variableMatch(ctx.Identifier().getText());
   }

   @Override
   public void exitStackAddressMatch(final StackAddressMatchContext ctx) {
      addressMatch = stackAddress(ctx.Identifier().getText());
   }
}
