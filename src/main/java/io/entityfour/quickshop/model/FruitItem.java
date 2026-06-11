package io.entityfour.quickshop.model;

import java.math.BigDecimal;

public class FruitItem extends AbstractItem {

  public FruitItem(String name, double basePrice, int daysToExpire, int quality) {
    super(name, basePrice, daysToExpire, quality);
  }

  @Override
  public void dailyUpdate() {
    daysToExpire --;
    if(daysToExpire < 0) {
      adjustQuality(-2);
    } else {
      adjustQuality(-1);
    }
  }

}
