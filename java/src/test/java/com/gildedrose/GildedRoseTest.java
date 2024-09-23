package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    @Test
    void testSingleItem() {
        Item[] items = new Item[]{new Item("foo", 1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0]).extracting("name", "sellIn", "quality")
                                .contains("foo", 0, 0);
    }

    @Test
    void testSingleItemZeroSellIn() {
        Item[] items = new Item[]{new Item("foo", 0, 3)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0]).extracting("name", "sellIn", "quality")
                                .contains("foo", -1, 1);
    }

    @Test
    void testAgedBrie() {
        Item[] items = new Item[]{new Item("Aged Brie", 1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0]).extracting("name", "sellIn", "quality")
                                .contains("Aged Brie", 0, 2);
    }

    @Test
    void testAgedBrieQty3() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 3)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0]).extracting("name", "sellIn", "quality")
                                .contains("Aged Brie", -1, 5);
    }

    @Test
    void testBackstagePasses() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0]).extracting("name", "sellIn", "quality")
                                .contains("Backstage passes to a TAFKAL80ETC concert", 0, 4);
    }

    @Test
    void testBackstagePassesQty3() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 3)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0]).extracting("name", "sellIn", "quality")
                                .contains("Backstage passes to a TAFKAL80ETC concert", -1, 0);
    }

    @Test
    void testSulfuras() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0]).extracting("name", "sellIn", "quality")
                                .contains("Sulfuras, Hand of Ragnaros", 1, 1);
    }

}
