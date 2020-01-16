package Assignment4;

import java.sql.*;
import java.util.ArrayList;

public class OperateItems {
    public ArrayList<Item> Items = new ArrayList<>();
    public ArrayList<Item> finalPricedItems = new ArrayList<>();
    private boolean stopCalculation=true;

    public void select() throws InterruptedException{
        String sql = "SELECT * FROM items";


        int maxCapacity=3;
        try {
            Connection conn = ConnectDB.getConnection();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);

            while (rs.next()) {

                synchronized(this)
                {

                    if(Items.size()==maxCapacity)
                        wait();

                    Item item1= new Item(rs.getString("Name"),rs.getString("type"), rs.getFloat("Price"), rs.getInt("quantity"));
                    Items.add(item1);

                    System.out.println("Item Added");
                    notify();

                    Thread.sleep(1000);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception while Reading from Database");
            stopCalculation=false;
        }

        stopCalculation=false;
    }

    public void CalculateTaxAndUpdatePrice() throws InterruptedException
    {

        while(stopCalculation || Items.size()!=0) {
            synchronized (this)
            {
                // consumer thread waits while list
                // is empty
                while (Items.size() == 0)
                    wait();

                Item i1= new Item();
                Item item = (Item) Items.get(0);
                double tax = i1.calculateTax(item.getType(), item.getPrice());

                Item itemfinal = new Item(item.getName(),item.getType(),((item.getPrice()+tax)*item.getQuantity()),item.getQuantity(),0);

                finalPricedItems.add(itemfinal);
                Items.remove(0);
                System.out.println("Item Retrieved");
                // Wake up producer thread
                notify();

                // and sleep
                Thread.sleep(1000);
            }
        }

    }

}
