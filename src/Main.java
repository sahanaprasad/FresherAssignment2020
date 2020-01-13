import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws IOException, ClassNotFoundException {
        int choice;
        CreateUser createuser=new CreateUser();
        createuser.readFromFile();
        int rollNumber;
        Scanner input=new Scanner(System.in);
        do{
            System.out.println("Choose any one of the options\n1.Add User details.");
            System.out.println("2.Display User details.\n3.Delete User details\n4.Save User details.\n5.Exit");

            choice=input.nextInt();

            switch(choice)
            {
                case 1: createuser.readUser();
                        break;
                case 3: System.out.println(("\"enter the roll number\""));
                        rollNumber=input.nextInt();
                        createuser.deleteDetails(rollNumber);
                        break;
                case 4: createuser.saveUserDetails();
                        break;
                case 2:createuser.displayDetails();
                        createuser.sorting();
                        break;
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
