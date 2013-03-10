package com.lexicalscope.supplant.supplantspecify;

import com.lexicalscope.supplant.supplantspecify.specification.Location;

public class LocationBuilder {
   private final String name;

   public LocationBuilder(final String name) {
      this.name = name;
   }

   public static LocationBuilder location(final String name) {
      return new LocationBuilder(name);
   }

   public Location build() {
      return new Location(name);
   }
}
