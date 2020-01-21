package assignment2.fileoperation;

import assignment2.model.User;

import static assignment2.UserManager.userslist;

public class DeleteFromFile {
  public static void deleteDetails(int rollNumber) {
    for (User user : userslist) {
      if (user.getRollNumber() == rollNumber) {
        System.out.println("deleting");
        userslist.remove(user);
        return;
      }
    }
    System.out.println("user not found");
  }
}
