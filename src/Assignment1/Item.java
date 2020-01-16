package Assignment1;

enum Type{RAW,IMPORTED,MANUFACTURED, DEFAULT}
public class Item {
    private String name;
    private Type type;
    private double price;
    private double tax;
    int quantity;
    private double finalPrice;
    boolean nameFlag, priceFlag, quantityFlag, typeFlag;
    public Item()
    {

    }

    public Item(String name, Type type, double price, int quantity, double tax) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.tax = tax;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice() {
        this.finalPrice =(tax+price*quantity);
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
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

    public void setType(Type type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTax() {
        this.tax =calculateTax();
    }

    public double calculateTax (){

        double itax=0;
        switch (type) {
            case RAW:
                itax = price * 0.125;

                break;
            case MANUFACTURED:
                tax = price* 0.125 + (price* 0.125 + price) * 0.02;
                break;
            case IMPORTED:
                tax = 0.1 * price;
                if (itax <= 100) itax += 5;
                else if (itax <= 200) itax += 10;
                else itax += 0.05 * (price + itax);
                break;
        }
    return (itax*(double)quantity);
    }

    @Override
    public String toString() {
        return "name=" + name + ", price=" + price + ", SalesTax=" + tax + ", FinalPrice=" + finalPrice;
    }

}
