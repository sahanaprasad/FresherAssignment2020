package assignment1.itemutilities;

import assignment1.model.Item;

public class ManufacturedItem extends Item {
  public ManufacturedItem(String name, Double price) {
    super(name, price);
    tax = 12.5 / 100 * price;
    tax += 2.0 / 100 * (price + tax);
  }
}