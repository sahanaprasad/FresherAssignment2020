package Assignment04;

import java.util.ArrayList;
import java.util.List;

public class thread{
    public static List<Item> items;
    public static boolean sync;
    public static boolean finish;

    thread(){
        items = new ArrayList<>();
        sync = false;
        finish = false;
    }
    CalculateTax tc=new CalculateTax();
    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            CalculateTax tc=new CalculateTax();
            tc.calculate();
        }
    });
    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            connectDB con =new connectDB();
            con.getItem();
        }
    });
    void start()
        {
            t1.start();
            t2.start();
        }
}