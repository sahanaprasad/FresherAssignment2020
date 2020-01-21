package assignment2;
import assignment2.model.User;

import java.util.*;


public class UserManager {
  public static final String FILENAME = "file1.ser";
  List<User> users;
  public Scanner scan;
  public static List<User> userslist = new ArrayList<>();

  public UserManager() {
    scan = new Scanner(System.in);
  }

  public void readUser() {
    User user = new User();
    System.out.println("Enter the Assignment2.User Details: ");
    user = checkUserInput(user);
    addUser(user);
    Collections.sort(userslist, new User.NameComparator());
  }

  public void addUser(User user) {
    userslist.add(user);
    System.out.println("user added to the list");
  }

  public User checkUserInput(User user1) {
    System.out.println("enter the name");
    String name = scan.next();
    System.out.println("enter the address");
    String address = scan.next();
    System.out.println("enter the age");
    int age = scan.nextInt();
    System.out.println("enter the rollnumber");
    int rollnumber = scan.nextInt();
    System.out.println("enter the courses(minimum 4 courses):A,B,C,D,E,F");
    String str = scan.next();
    List<String> ch = Arrays.asList(str.split(","));
    if (ch.size() < 4) {
      System.out.println("enter at least 4 courses");
      str = scan.next();
    }
    user1.setName(name);
    user1.setAge(age);
    user1.setAddress(address);
    user1.setRollNumber(rollnumber);
    user1.setCourses(ch);
    return user1;

  }

  public void displayDetails() {
    userslist.forEach(user -> System.out.println(user));
  }

  public void sorting() {
    int choicesort;
    System.out.println("1.sort based on name\n2.sort based on age\n3.sort based on roll number");
    choicesort = scan.nextInt();
    switch (choicesort) {
      case 1: Collections.sort(userslist, new User.NameComparator());
        break;
      case 2: Collections.sort(userslist, new User.ageComparator());
        break;
      case 3: Collections.sort(userslist, new User.RollnumberComparator());
        break;
      default:break;
    }
    displayDetails();
  }


}