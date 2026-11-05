/*
 * OOPS Programming - I | Q1
 * WAP to create class Student and more than 1 object of the same class.
 * Assign different values to these objects.
 */
class Student {
    String name;
    int rollNo;
    int marks;

    void display() {
        System.out.println("Name: " + name + " | Roll No: " + rollNo + " | Marks: " + marks);
    }
}

public class Main {
    public static void main(String[] args) {
        // Three different objects of the same class
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();

        // Different values for each object
        s1.name = "Ananya";
        s1.rollNo = 101;
        s1.marks = 88;

        s2.name = "Rahul";
        s2.rollNo = 102;
        s2.marks = 76;

        s3.name = "Priya";
        s3.rollNo = 103;
        s3.marks = 92;

        System.out.println("Student details:");
        s1.display();
        s2.display();
        s3.display();
    }
}
