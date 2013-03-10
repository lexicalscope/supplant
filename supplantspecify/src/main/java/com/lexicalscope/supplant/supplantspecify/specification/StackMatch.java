package com.lexicalscope.supplant.supplantspecify.specification;


public class StackMatch extends AbstractSpecificationElement{
   private final VariableMatch variableMatch;
   private final ObjectMatch objectMatch;

   public StackMatch(
         final VariableMatch variableMatch,
         final ObjectMatch objectMatch) {
      this.variableMatch = variableMatch;
      this.objectMatch = objectMatch;
   }
}
