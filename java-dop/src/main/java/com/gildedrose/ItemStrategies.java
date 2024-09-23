package com.gildedrose;

public class ItemStrategies {
    record AgedBrie() implements ItemStrategy {}
    record Sulfuras() implements ItemStrategy {}
    record BackstagePasses() implements ItemStrategy {}
    record AnyOther() implements ItemStrategy {}
}
