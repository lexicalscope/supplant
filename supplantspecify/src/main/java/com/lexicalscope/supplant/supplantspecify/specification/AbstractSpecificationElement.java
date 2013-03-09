package com.lexicalscope.supplant.supplantspecify.specification;

import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class AbstractSpecificationElement {
   @Override public final String toString() {
      return reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
   }

   @Override public final int hashCode() {
      return reflectionHashCode(this);
   }

   @Override public boolean equals(final Object that) {
      return EqualsBuilder.reflectionEquals(this, that);
   }
}
