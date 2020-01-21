package assignment2.threads;

import static assignment2.fileoperation.DeleteFromFile.deleteDetails;
import static assignment2.fileoperation.ReadFromFile.read;
import assignment2.UserManager;
import static assignment2.fileoperation.WriteToFile.write;

import java.io.IOException;
import java.util.Scanner;

public class UserThread {
  public static void run() throws IOException, ClassNotFoundException {
    int choice;
    UserManager usermanager = new UserManager();
    read();
    int rollNumber;
    Scanner input = new Scanner(System.in);
    do{
    System.out.println("Choose any one of the options\n1.Add Assignment2.User details.");
    System.out.println("2.Display Assignment2.User details.\n3.Delete Assignment2.User details");
    System.out.println("4.Save Assignment2.User details.\n5.Exit");
    choice = input.nextInt();
    switch(choice)
    {
      case 1:usermanager.readUser();
        break;
      case 2:usermanager.displayDetails();
        usermanager.sorting();
        break;
      case 3: System.out.println(("\"enter the roll number\""));
        rollNumber = input.nextInt();
        deleteDetails(rollNumber);
        break;
      case 4: write();
        break;
      default:System.out.println("please enter valid input");
        break;

    }
  } while(choice != 5);
        System.out.println("do you want to save the changes?(y/n)");
  String choice2 = input.next();
        if(choice2.equals("y")) {
    write();
    System.out.println("changes have been successfully saved ");

  }
}
}
