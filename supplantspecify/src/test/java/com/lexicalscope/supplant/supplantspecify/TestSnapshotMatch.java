package com.lexicalscope.supplant.supplantspecify;

import static com.lexicalscope.supplant.supplantspecify.AddressMatchBuilder.*;
import static com.lexicalscope.supplant.supplantspecify.BindingBuilder.binding;
import static com.lexicalscope.supplant.supplantspecify.HeapMatchBuilder.heapMatch;
import static com.lexicalscope.supplant.supplantspecify.LocationBuilder.location;
import static com.lexicalscope.supplant.supplantspecify.ObjectMatchBuilder.objectWithType;
import static com.lexicalscope.supplant.supplantspecify.SnapshotMatchBuilder.newSnapshotMatch;
import static com.lexicalscope.supplant.supplantspecify.StackMatchBuilder.stackMatch;
import static com.lexicalscope.supplant.supplantspecify.VariableMatchBuilder.variableMatch;

import org.junit.Test;

public class TestSnapshotMatch extends AbstractTestSpecification {
   @Test
   public void testSnapshotStackMatch() {
      assertSnapshotMatch("<this->{MyType}>",
            newSnapshotMatch().with(stackMatch(variableMatch("this"), objectWithType("MyType"))));
   }

   @Test
   public void testHeapMatchAddressFromStack() {
      assertSnapshotMatch("[<this>->{MyType}]",
            newSnapshotMatch().with(heapMatch().with(stackAddress("this"), objectWithType("MyType"))));
   }

   @Test
   public void testSnapshotHeapMatch() {
      assertSnapshotMatch("[*:a->{Page}]",
            newSnapshotMatch().with(heapMatch().with(bindingWildcardAddress(binding("a")), objectWithType("Page"))));
   }

   @Test
   public void testSnapshotHeapMatchWithStackAddress() {
      assertSnapshotMatch("[<this>->{Page}]",
            newSnapshotMatch().with(heapMatch().with(stackAddress("this"), objectWithType("Page"))));
   }

   @Test
   public void testSnapshotWithLocation() {
      assertSnapshotMatch("@r [*]",
            newSnapshotMatch(location("r"), heapMatch()));
   }
}
