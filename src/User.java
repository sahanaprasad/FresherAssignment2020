import java.util.*;
import java.io.Serializable;

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
        return "User [name=" + name + ", address=" + address + ", age=" + age + ", roll_number=" + rollNumber + ", courses=" + courses + "]";
    }
        static class NameComparator implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            int result = o1.getName().compareTo(o2.getName());
            if(result == 0) {
                return Integer.compare(o1.getRollNumber(), o2.getRollNumber());
            }
            return result;
        }

    }
    static class ageComparator implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
           // int result = o1.getAge().compareTo(o2.getName());
            //if(result == 0) {
                return Integer.compare(o1.getAge(), o2.getAge());
           // }
           // return result;
        }
    }
    static class RollComparator implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            // int result = o1.getAge().compareTo(o2.getName());
            //if(result == 0) {
            return Integer.compare(o1.getRollNumber(), o2.getRollNumber());
            // }
            // return result;
        }
    }
   /* @Override
    public int compareTo(User o) {
        return (((User) o).getName()).compareTo(this.getName());
    }*/
//   static class ageComparator implements Comparator<User> {
//       @Override
//       public int compare(User o1, User o2) {
//           return o1.getAge().compareTo(o2.getName());
//       }

   }



