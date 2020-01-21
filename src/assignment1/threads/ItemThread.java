package assignment1.threads;

import assignment1.itemutilities.ItemOperation;

import java.util.Scanner;


public class ItemThread {
  public static void run() {
    Scanner input = new Scanner(System.in);
    String choice = "";
    ItemOperation items = new ItemOperation();
    System.out.print("-name <first item name>\n-price <price of first item>\n");
    System.out.println("-quantity <quantity of first item>\n -type <type of first item>");
    do {
      items.readItems();
      System.out.println("Do you want to enter details of any other item (y/n)");
      choice = input.nextLine();
    } while (choice.equals("y"));
    items.displayItems();
  }

}
