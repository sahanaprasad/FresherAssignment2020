package Assignment2;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws IOException, ClassNotFoundException {
        int choice;
        userOperation createuser=new userOperation();
        createuser.readFromFile();
        int rollNumber;
        Scanner input=new Scanner(System.in);
        do{
            System.out.println("Choose any one of the options\n1.Add Assignment2.User details.");
            System.out.println("2.Display Assignment2.User details.\n3.Delete Assignment2.User details\n4.Save Assignment2.User details.\n5.Exit");

            choice=input.nextInt();

            switch(choice)
            {
                case 1: createuser.readUser();
                        break;
                case 2:createuser.displayDetails();
                       createuser.sorting();
                       break;
                case 3: System.out.println(("\"enter the roll number\""));
                        rollNumber=input.nextInt();
                        createuser.deleteDetails(rollNumber);
                        break;
                case 4: createuser.saveUserDetails();
                        break;
                default: break;

            }
        }while(choice!=5);
        System.out.println("do you want to save the changes?(y/n)");
        String choice2=input.next();
        if(choice2.equals("y"))
        {
            createuser.saveUserDetails();
            System.out.println("changes have been successfully saved ");

        }
    }
}
