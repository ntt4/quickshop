package io.entityfour.quickshop.service;

import io.entityfour.quickshop.model.InventoryItem;
import java.util.List;

public interface InventoryService {

  void processDailyUpdates(List<InventoryItem> inventoryItems);
  void simulateDays(List<InventoryItem> inventoryItems, int daysToSimulate);
  List<InventoryItem> getExpiredInventoryItems(List<InventoryItem> inventoryItems);
  double calculateTotalValue(List<InventoryItem> inventoryItems);

}
