/*
 * Chapter 2 | Program 10 (Challenging): Multilevel inheritance
 * Person -> Employee -> Manager
 */
class Person {
    protected String name;
    protected int age;

    Person(String name, int age) {
        System.out.println("Person constructor");
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + name + " | Age: " + age);
    }
}

class Employee extends Person {
    protected int empId;
    protected double basicSalary;

    Employee(String name, int age, int empId, double basicSalary) {
        super(name, age);                 // calls the Person constructor
        System.out.println("Employee constructor");
        this.empId = empId;
        this.basicSalary = basicSalary;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Employee ID: " + empId + " | Basic Salary: " + basicSalary);
    }
}

class Manager extends Employee {
    private String department;
    private double bonus;

    Manager(String name, int age, int empId, double basicSalary, String department, double bonus) {
        super(name, age, empId, basicSalary);   // calls the Employee constructor
        System.out.println("Manager constructor");
        this.department = department;
        this.bonus = bonus;
    }

    double calculateTotalSalary() {
        return basicSalary + bonus;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Department: " + department + " | Bonus: " + bonus);
        System.out.printf("Total Salary: %.2f%n", calculateTotalSalary());
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Creating a Manager object:");
        Manager m = new Manager("Ananya Sharma", 35, 7001, 80000, "Computer Science", 15000);

        System.out.println("\nManager details:");
        m.display();
    }
}

/*
 * PREDICTED ORDER OF CONSTRUCTOR MESSAGES when a Manager object is created:
 *   Person constructor
 *   Employee constructor
 *   Manager constructor
 *
 * Why? new Manager(...) starts the Manager constructor, but its FIRST action is super(...),
 * which starts the Employee constructor; that in turn first calls super(...), which runs the
 * Person constructor. The topmost parent (Person) finishes first, then Employee, and Manager's
 * own body runs last. Constructors therefore execute from parent to child (top to bottom of the
 * hierarchy), even though the call starts at the child.
 */
