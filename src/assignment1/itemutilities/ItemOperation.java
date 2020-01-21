package assignment1.itemutilities;

import assignment1.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class ItemOperation {
  private List<Item> itemsList;
  private Scanner input;
  Logger logger = Logger.getLogger("com.api.jar");

  public ItemOperation() {
    input = new Scanner(System.in);
    itemsList = new ArrayList<>();
  }

  public void readItems() {
    logger.info("Enter the item details: ");
    getItemInput();
  }

  String addItem(Item item) {
    if (item.getName().isBlank()) {
      return ("No name entered");
    }
    if (item.getPrice() < 0) {
      return ("price should be positive");
    }
    if (item.getQuantity() < 0) {
      return ("Quantity should be positive");
    }

    itemsList.add(item);
    return "item added successfully";
  }

  public void displayDetails() {
    System.out.println(itemsList);
  }

  public void displayItems() {
    itemsList.forEach(item -> System.out.println(item));
  }

  private void getItemInput() {
    System.out.println("-name");
    String name =input.next();
    //item.setName(name);
    System.out.println("Name added");
    System.out.println("-type");
    String type = input.next();

    System.out.println("Type added");
    System.out.println("-price");
    double price = input.nextDouble();

    System.out.println("price added");

    System.out.println("quantity added");
    Item item= new ItemFactory().getItem(name,type,price);
    System.out.println("-quantity");
    item.setQuantity(input.nextInt());
    itemsList.add(item);





  }

}
