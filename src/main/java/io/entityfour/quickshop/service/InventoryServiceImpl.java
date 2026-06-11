package io.entityfour.quickshop.service;

import io.entityfour.quickshop.model.InventoryItem;
import java.util.ArrayList;
import java.util.List;

public class InventoryServiceImpl implements InventoryService {

  @Override
  public void processDailyUpdates(List<InventoryItem> inventoryItems) {
    for (InventoryItem inventoryItem : inventoryItems) {
      inventoryItem.dailyUpdate();
    }
  }

  @Override
  public void simulateDays(List<InventoryItem> inventoryItems, int daysToSimulate) {
    for (int i = 0; i < daysToSimulate; i++) {
      processDailyUpdates(inventoryItems);
    }
  }

  @Override
  public List<InventoryItem> getExpiredInventoryItems(List<InventoryItem> inventoryItems) {
    List<InventoryItem> expiredInventoryItems = new ArrayList<>();
    for (InventoryItem inventoryItem : inventoryItems) {
      if (inventoryItem.getDaysToExpire() < 0) {
        expiredInventoryItems.add(inventoryItem);
      }
    }
    return expiredInventoryItems;
  }

  @Override
  public double calculateTotalValue(List<InventoryItem> inventoryItems) {

    double total = 0.0;
    for (InventoryItem inventoryItem : inventoryItems) {
      total += inventoryItem.getPrice();
    }
    return total;
  }
}
