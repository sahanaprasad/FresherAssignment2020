package Assignment04;

import java.util.ArrayList;
import java.util.List;
public class Assignment4Threads {
    public static List<Item> items;
    public static boolean sync;
    public static boolean finish;

    Assignment4Threads(){
        items = new ArrayList<>();
        sync = false;
        finish = false;
    }
    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            connectDB con = new connectDB();
            con.getItem();
        }
    });
    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            CalculateTax ct = new CalculateTax();
            ct.calculate();
        }
    });
    void start(){
      t1.start();
      t2.start();
    }
}
















