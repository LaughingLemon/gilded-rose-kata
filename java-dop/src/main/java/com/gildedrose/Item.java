package com.gildedrose;

public record Item(String name, int sellIn, int quality, ItemStrategy strategy) {

    @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
