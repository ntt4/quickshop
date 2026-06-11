package io.entityfour.quickshop.model;

import io.entityfour.quickshop.service.InventoryService;

public abstract class AbstractItem implements InventoryItem {

  private final String name;
  protected double basePrice;
  protected int daysToExpire;
  protected int quality;

  public AbstractItem(String name, double basePrice, int daysToExpire, int quality) {
    this.name = name;
    this.basePrice = basePrice;
    this.daysToExpire = daysToExpire;
    this.quality = Math.clamp(quality, 0, 50);
  }

  protected void adjustQuality(int amount) {
    this.quality += amount;
    if (this.quality > 50) {
      this.quality = 50;
    }
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public double getPrice() {
    return this.basePrice + this.quality;
  }

  @Override
  public int getDaysToExpire() {
    return this.daysToExpire;
  }

  @Override
  public int getQuality() {
    return this.quality;
  }
}
