package com.lexicalscope.supplant.supplantspecify;

public class LocationBuilder {
   private final String name;

   public LocationBuilder(final String name) {
      this.name = name;
   }

   public static LocationBuilder location(final String name) {
      return new LocationBuilder(name);
   }
}
