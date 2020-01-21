package assignment2.fileoperation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
//import second_assignment.userOperation.

import static assignment2.UserManager.FILENAME;
import static assignment2.UserManager.userslist;

public class WriteToFile {
  public static void write() {
    //String filename = "file1.ser";
    try {
      FileOutputStream file = new FileOutputStream(FILENAME);
      ObjectOutputStream out = new ObjectOutputStream(file);
      System.out.println("sorted");
      out.writeObject(userslist);
      out.close();
      file.close();
      System.out.println("Object has been serialized");
    } catch (IOException ex) {
      System.out.println("IOException is caught");
    }
  }
}
