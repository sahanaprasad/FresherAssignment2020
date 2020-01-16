package Assignment3;

import Assignment3.Exception.NodeDoesNotExist;
import Assignment3.GraphOperation;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) throws NodeDoesNotExist {
            GraphOperation opt=new GraphOperation();
            int choice;
            do{
            System.out.println("1.Get the immediate parents of a node\n2.Get the immediate children of a node\n3.Get the ancestors of a node\n4.Get the descendants of a node\n5.Delete dependency from a tree\n6.Delete a node from a tree\n7.Add a new dependency to a tree\n8.Add a new node to tree");
            System.out.println("9.Exit");
            Scanner input=new Scanner(System.in);
            System.out.println("enter your choice");
            choice =input.nextInt();
            int cid,pid;
            switch(choice)
            {
                case 1:System.out.println("enter the child ID");
                        int childid=input.nextInt();
                       try{ opt.getImmediateParent(childid);}
                       catch (NodeDoesNotExist e){
                           System.out.println(e.getMessage());
                       }
                        break;
                case 2: System.out.println("enter the parent ID");
                        int parentid=input.nextInt();
                        try{opt.getImmediateChildren(parentid);}
                        catch (NodeDoesNotExist e){
                            System.out.println(e.getMessage());
                        }
                        break;
                case 3:System.out.println("enter the child ID");
                        cid=input.nextInt();
                        try{opt.getAncestors(cid);}
                        catch (NodeDoesNotExist e){
                            System.out.println(e.getMessage());
                        }
                        break;
                case 4:System.out.println("enter the parent ID");
                        pid=input.nextInt();
                        try{opt.getDescendants(pid);}
                        catch (NodeDoesNotExist e){
                            System.out.println(e.getMessage());
                        }
                        break;
                case 5: System.out.println("enter the parent ID");
                         pid=input.nextInt();
                        System.out.println("enter the child ID");
                        cid=input.nextInt();
                        opt.deleteDependency(pid,cid);
                        break;
                case 6:opt.deleteNode();
                        break;
                case 7: opt.addDependency();
                        break;
                case 8: opt.addNode();
                        break;
                default: break;

            }}while(choice!=9);


    }

}
