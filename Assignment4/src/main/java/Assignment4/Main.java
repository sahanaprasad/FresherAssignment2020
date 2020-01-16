package Assignment4;


import java.sql.SQLException;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        thread t = new thread();
        t.start();
    }
}