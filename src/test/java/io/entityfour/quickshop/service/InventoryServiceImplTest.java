package io.entityfour.quickshop.service;

import static org.junit.jupiter.api.Assertions.*;

import io.entityfour.quickshop.model.FruitItem;
import io.entityfour.quickshop.model.InventoryItem;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InventoryServiceImplTest {

  private InventoryService inventoryService;

  @BeforeEach
  public void setup() {
    inventoryService = new InventoryServiceImpl();
  }

  @Test
  public void testFruitQualityNeverDropsBelowZero() {
    InventoryItem apple = new FruitItem("Apple", 2.00, 5, 0);

    apple.dailyUpdate();

    assertEquals(0, apple.getQuality(), "Quality should not drop below zero.");
  }

  @Test
  public void testSimulateMultipleDays() {
    InventoryItem apple = new FruitItem("Apple", 2.00, 5, 10);
    List<InventoryItem> inventoryItems = Arrays.asList(apple);

    inventoryService.simulateDays(inventoryItems, 3);

    assertEquals(2, apple.getDaysToExpire());
    assertEquals(7, apple.getQuality());
  }
}
