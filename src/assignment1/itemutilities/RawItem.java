package assignment1.itemutilities;

import assignment1.model.Item;

public class RawItem extends Item {

  public RawItem(String name, Double price) {
    super(name, price);
    tax = 12.5 / 100 * price;
  }
}

