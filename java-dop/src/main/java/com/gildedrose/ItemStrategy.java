package com.gildedrose;

public sealed interface ItemStrategy permits ItemStrategies.AgedBrie,
                                             ItemStrategies.AnyOther,
                                             ItemStrategies.BackstagePasses,
                                             ItemStrategies.Sulfuras {
}
