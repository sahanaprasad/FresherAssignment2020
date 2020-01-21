package assignment2.model;

import java.io.Serializable;
import java.util.*;

public class User implements Serializable{

   private String name, address;
   private int age, rollNumber;
   List<String> courses = new ArrayList<>();

   public String getName() {
     return name;
   }

   public void setName(String name) {
     this.name = name;
   }

   public String getAddress() {
     return address;
   }

   public void setAddress(String adderess) {
     this.address = adderess;
   }

   public int getAge() {
     return age;
   }

   public void setAge(int age) {
     this.age = age;
   }

   public int getRollNumber() {
     return rollNumber;
   }

   public void setRollNumber(int rollNumber) {
     this.rollNumber = rollNumber;
   }

   public List<String> getCourses() {
     return courses;
   }

   public void setCourses(List<String> courses) {
     this.courses = courses;
   }

   @Override
   public String toString() {
     return "User: name=" + name + ", address=" + address + ", age=" + age + ", roll_number=" + rollNumber + ", courses=" + courses;
   }
     public static class NameComparator implements Comparator<User> {
     @Override
     public int compare(User o1, User o2) {
       int result = o1.getName().compareTo(o2.getName());
       if(result == 0) {
         return Integer.compare(o1.getRollNumber(), o2.getRollNumber());
       }
       return result;
     }

   }
   public static class ageComparator implements Comparator<User> {
     @Override
     public int compare(User o1, User o2) {
       return Integer.compare(o1.getAge(), o2.getAge());
     }
   }
   public static class RollnumberComparator implements Comparator<User> {
     @Override
     public int compare(User o1, User o2) {
         return Integer.compare(o1.getRollNumber(), o2.getRollNumber());
     }
   }
}



