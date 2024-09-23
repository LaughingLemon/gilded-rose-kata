package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public Item updateSulfuras(Item item) {
        return item;
    }

    public Item updateAgedBrie(Item item) {
        int newSellIn;
        int newQuality = 0;
        if (item.quality() < 50) {
            newQuality = item.quality() + 1;
        }
        newSellIn = item.sellIn() - 1;
        if (newSellIn < 0 && newQuality < 50) {
            newQuality++;
        }
        return new Item(item.name(), newSellIn, newQuality, item.strategy());
    }

    public Item updateBackstagePasses(Item item) {
        int newSellIn;
        int newQuality = 0;
        if (item.quality() < 50) {
            newQuality = item.quality() + 1;
            if (item.sellIn() < 11 && newQuality < 50) {
                newQuality++;
            }

            if (item.sellIn() < 6 && newQuality < 50) {
                newQuality++;
            }
        }
        newSellIn = item.sellIn() - 1;
        if (newSellIn < 0) {
            newQuality = 0;
        }
        return new Item(item.name(), newSellIn, newQuality, item.strategy());
    }

    public Item updateAnythingElse(Item item) {
        int newSellIn;
        int newQuality = 0;
        if (item.quality() > 0) {
            newQuality = item.quality() - 1;
        }
        newSellIn = item.sellIn() - 1;
        if (newSellIn < 0) {
            newQuality = newQuality - 1;
        }
        return new Item(item.name(), newSellIn, newQuality, item.strategy());
    }

    public void updateQuality() {
        items = Arrays.stream(items)
                      .map(item ->
                          switch (item.strategy()) {
                              case ItemStrategies.AgedBrie _ -> updateAgedBrie(item);
                              case ItemStrategies.BackstagePasses _ -> updateBackstagePasses(item);
                              case ItemStrategies.Sulfuras _ -> updateSulfuras(item);
                              case ItemStrategies.AnyOther _ -> updateAnythingElse(item);
                          }
                      ).toArray(Item[]::new);
    }
}
