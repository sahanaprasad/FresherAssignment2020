package Assignment04;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class connectDB {
    private Connection conn;
    List<Item> items=new ArrayList<>();
    public connectDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String connectionUrl = "jdbc:mysql://127.0.0.1:3306/assignment?useUnicode=true&characterEncoding=UTF-8&user=root&password=root@123";
        try {
            conn = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getItem() {
        try {
            ResultSet rs = conn.prepareStatement("select * from items2").executeQuery();

            while (rs.next()) {
                Item item = new Item();
                item.setName(rs.getString(1));
                item.setType(rs.getString(2));
                item.setQuantity(rs.getDouble(4));
                item.setPrice(rs.getDouble(3));
                while (thread.sync) ;
                thread.sync = true;
                thread.items.add(item);
                thread.sync = false;
                System.out.println("Addded new item: "+ thread.items.size()+" to list");
            }
            thread.finish = true;
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}