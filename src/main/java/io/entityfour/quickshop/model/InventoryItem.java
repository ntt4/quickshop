package io.entityfour.quickshop.model;

public interface InventoryItem {

  void dailyUpdate();
  double getPrice();
  String getName();
  int getDaysToExpire();
  int getQuality();
}
