package com.lexicalscope.supplant.supplantspecify;

import com.lexicalscope.supplant.supplantspecify.specification.StackMatch;

public class StackMatchBuilder {
   private VariableMatchBuilder variableMatch;
   private ObjectMatchBuilder objectMatch;

   public static StackMatchBuilder stackMatch() {
      return new StackMatchBuilder();
   }

   public static StackMatchBuilder stackMatch(final VariableMatchBuilder variableMatch, final ObjectMatchBuilder objectMatch) {
      return stackMatch().with(variableMatch).with(objectMatch);
   }

   StackMatchBuilder with(final ObjectMatchBuilder objectMatch) {
      this.objectMatch = objectMatch;
      return this;
   }

   public StackMatchBuilder with(final VariableMatchBuilder variableMatch) {
      this.variableMatch = variableMatch;
      return this;
   }

   public StackMatch build() {
      return new StackMatch(
            variableMatch != null ? variableMatch.build() : null,
            objectMatch != null ? objectMatch.build() : null);
   }
}
