package assignment2.fileoperation;

import assignment2.model.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import static assignment2.UserManager.FILENAME;
import static assignment2.UserManager.userslist;

public class ReadFromFile {
  public static  void  read() throws IOException, ClassNotFoundException {
    File toread=new File(FILENAME);
    FileInputStream fileInputStream=new FileInputStream(toread);
    ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
    userslist = (List<User>)objectInputStream.readObject();
    for(User user:userslist)
    {
      System.out.println(user);

    }
  }
}
