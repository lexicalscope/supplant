package com.lexicalscope.supplant.supplantspecify.specification;

import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class AbstractSpecificationElement {
   @Override
   public final String toString() {
      return reflectionToString(this, new ToStringStyle() {
         {
            this.setUseClassName(true);
            this.setUseShortClassName(true);
            this.setUseIdentityHashCode(false);
            this.setUseFieldNames(false);
            this.setContentStart("(");
            this.setContentEnd(")");
         }

         @Override
         public void appendStart(final StringBuffer buffer, final Object object) {
            if (object != null) {
               appendContentStart(buffer);
               appendClassName(buffer, object);
               buffer.append(" ");
               appendIdentityHashCode(buffer, object);
            }
         }

      });
   }

   @Override
   public final int hashCode() {
      return reflectionHashCode(this);
   }

   @Override
   public boolean equals(final Object that) {
      return EqualsBuilder.reflectionEquals(this, that);
   }
}
