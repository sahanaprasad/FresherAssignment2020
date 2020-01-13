package Assignment2;

import java.io.*;
import java.util.*;

public class CreateUser {
    List<User> users;
    private Scanner scan;
    List<User> readingUsers=new ArrayList<>();

    CreateUser() {
        scan = new Scanner(System.in);

    }

    public void readUser() {
        User user = new User();
        System.out.println("Enter the Assignment2.User Details: ");
        user = checkUserInput(user);
       // System.out.println("hello");
        addUser(user);
        Collections.sort(readingUsers, new User.NameComparator());
        //Collections.sort(readingUsers);
        //users.add(user);
        //System.out.println("user  added successfully");
    }

    void addUser(User user) {
       // System.out.println("hello2");
        if (user.getName().equals(""))
            return;
        if (user.getAddress().equals(""))
            return;
        if (user.getAge() < 0)
            return;
        if (user.getRollNumber() < 0)
            return;

        readingUsers.add(user);

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
    public void deleteDetails(int rollNumber)
    {
        for (User user1 : readingUsers)
        {
            if(user1.getRollNumber()==rollNumber){
                System.out.println("deleting");
                readingUsers.remove(user1);
                return;
            }
        }
        System.out.println("user not found");
    }
    public void displayDetails() {
//
        System.out.println("Name   \t\tAGE \t\tROLL NUMBER \t\tCOURSES");
        System.out.println("----\t\t-----\t\t----------\t\t-----------");
        //System.out.println(users.size());
        for (User user1 : readingUsers)
            System.out.println(user1.getName() + "\t\t" + user1.getAge() + "\t\t\t" + user1.getRollNumber() + "\t\t\t\t" + user1.getCourses());
    }
    public void sorting()
    {
        int choicesort;
        System.out.println("1.sort based on name\n2.sort based on age\n3.sort based on roll number");
        choicesort=scan.nextInt();
        switch(choicesort){
            case 1: Collections.sort(readingUsers, new User.NameComparator());
                    break;
            case 2: Collections.sort(readingUsers, new User.ageComparator());
                    break;
            case 3: Collections.sort(readingUsers, new User.RollComparator());
                    break;
        }
        displayDetails();
    }

    public void saveUserDetails() {
        String filename = "file1.ser";
        try {
            //Saving of object in a file
            //System.out.println("hellosave");
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
           // System.out.println(readingUsers.size());
            // Method for serialization of object

            System.out.println("sorted");
            out.writeObject(readingUsers);
            //System.out.println(readingUsers.size());

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }
    }



    public void  readFromFile() throws IOException, ClassNotFoundException {
        File toRead=new File("file1.ser");
        FileInputStream f=new FileInputStream(toRead);
        ObjectInputStream o=new ObjectInputStream(f);
        readingUsers = (List<User>)o.readObject();
        System.out.println("Name \t\tAGE \t\tROLL NUMBER \t\tCOURSES");
        System.out.println("----\t\t-----\t\t----------\t\t-----------");

        for(User user1:readingUsers)
        {

            System.out.println(user1.getName() + "\t\t" + user1.getAge() + "\t\t\t" + user1.getRollNumber() + "\t\t\t\t" + user1.getCourses());
        }
    }
}
