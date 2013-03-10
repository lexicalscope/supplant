package com.lexicalscope.supplant.supplantspecify;

import com.lexicalscope.supplant.supplantspecify.specification.VariableMatch;

public class VariableMatchBuilder {
   private final String text;

   public VariableMatchBuilder(final String text) {
      this.text = text;
   }

   public static VariableMatchBuilder variableMatch(final String text) {
      return new VariableMatchBuilder(text);
   }

   public VariableMatch build() {
      return new VariableMatch(text);
   }
}
