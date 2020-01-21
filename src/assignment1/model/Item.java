package assignment1.model;

public class Item {

//  public enum ItemType {
//    RAW {
//      @Override
//        double taxCalculator(double price) {
//        return price * 0.125;
//      }
//    },
//    IMPORTED {
//      @Override
//        double taxCalculator(double price) {
//        return price * 0.125 + (price * 0.125 + price) * 0.02;
//      }
//    },
//    MANUFACTURED {
//      @Override
//        public double taxCalculator(double price) {
//        double itax = 0.1 * price;
//        if (itax <= 100) {
//          itax += 5;
//        } else if (itax <= 200) {
//          itax += 10;
//        } else {
//          itax += 0.05 * (price + itax);
//        }
//        return itax;
//      }
//    };
//    abstract double taxCalculator(double price);
//  }


  private String name;
  private double price;
  public double tax = 0.0;
  int quantity;
  private double finalPrice;

  public Item() {

  }

  public Item(String name, Double price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setTax(int itax) {
    this.tax = itax;
  }

  public double getTax() {
    return tax;
  }

  public double getPrice() {
    return price;
  }

  public double getQuantity() {
    return quantity;
  }

  public void setName(String name) {
    this.name = name;
  }


  public void setPrice(double price) {
    this.price = price;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }


  public double getFinalPrice() {
    return finalPrice;
  }

  public void setFinalPrice() {

    this.finalPrice = tax + price * quantity;
  }

}
