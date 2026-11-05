/*
 * Chapter 2 | Program 14 (Mini project): College management system using inheritance
 *
 * Hierarchy:
 *                 Person
 *        /           |            \
 *    Student      Faculty     Administrator
 */
class Person {
    // final constant: common institutional value that never changes
    public static final String COLLEGE_NAME = "XYZ Institute of Technology";

    // static count of all people created
    private static int totalPeople = 0;

    // private fields, accessed through public methods
    private final String name;
    private final int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
        totalPeople++;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static int getTotalPeople() {
        return totalPeople;
    }

    // Overridden by every subclass (run-time polymorphism)
    public void displayDetails() {
        System.out.println("Name: " + name + " | Age: " + age + " | College: " + COLLEGE_NAME);
    }

    // OVERLOADED methods (same name, different parameters)
    public void greet() {
        System.out.println("Hello, I am " + name + ".");
    }

    public void greet(String greeting) {
        System.out.println(greeting + ", I am " + name + ".");
    }

    // NESTED class representing a college department
    static class Department {
        private final String departmentName;
        private final String headOfDepartment;

        Department(String departmentName, String headOfDepartment) {
            this.departmentName = departmentName;
            this.headOfDepartment = headOfDepartment;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public void display() {
            System.out.println("Department: " + departmentName + " | HOD: " + headOfDepartment);
        }
    }
}

class Student extends Person {
    private final String usn;
    private final int semester;
    private final Person.Department department;

    Student(String name, int age, String usn, int semester, Person.Department department) {
        super(name, age);
        this.usn = usn;
        this.semester = semester;
        this.department = department;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("  Role: Student | USN: " + usn + " | Semester: " + semester
                + " | Department: " + department.getDepartmentName());
    }
}

class Faculty extends Person {
    private final String employeeId;
    private final String designation;
    private final Person.Department department;

    Faculty(String name, int age, String employeeId, String designation, Person.Department department) {
        super(name, age);
        this.employeeId = employeeId;
        this.designation = designation;
        this.department = department;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("  Role: Faculty | Emp ID: " + employeeId + " | Designation: " + designation
                + " | Department: " + department.getDepartmentName());
    }
}

class Administrator extends Person {
    private final String employeeId;
    private final String office;

    Administrator(String name, int age, String employeeId, String office) {
        super(name, age);
        this.employeeId = employeeId;
        this.office = office;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("  Role: Administrator | Emp ID: " + employeeId + " | Office: " + office);
    }
}

public class Main {
    public static void main(String[] args) {
        Person.Department cse = new Person.Department("Computer Science", "Dr. Meera Rao");
        Person.Department ece = new Person.Department("Electronics", "Dr. Suresh Kumar");

        System.out.println("=== Departments (nested class) ===");
        cse.display();
        ece.display();

        // Person[] array holding objects of all three subclasses
        Person[] people = new Person[4];
        people[0] = new Student("Ananya Sharma", 20, "1XY24CS001", 3, cse);
        people[1] = new Student("Rahul Verma", 21, "1XY24EC014", 3, ece);
        people[2] = new Faculty("Dr. Meera Rao", 45, "F1001", "Professor", cse);
        people[3] = new Administrator("Mr. Kiran Patil", 38, "A2001", "Admissions Office");

        // Run-time polymorphism: same call, version depends on the actual object
        System.out.println("\n=== displayDetails() through Person[] ===");
        for (Person p : people) {
            p.displayDetails();
        }

        // Overloaded method
        System.out.println("\n=== Overloaded greet() ===");
        people[0].greet();
        people[2].greet("Good morning");

        System.out.println("\nCollege (final constant): " + Person.COLLEGE_NAME);
        System.out.println("Total people created (static count): " + Person.getTotalPeople());
    }
}

/*
 * CHALLENGE: Class hierarchy and the concepts demonstrated by each class
 *
 *                      Person
 *                (parent / base class)
 *             /          |            \
 *        Student      Faculty      Administrator
 *
 * Person (parent class)
 *   - Encapsulation: private name and age, accessed through public getters.
 *   - static variable + static method: totalPeople / getTotalPeople() count every object created.
 *   - final constant: COLLEGE_NAME is a fixed institutional value.
 *   - Method overloading: greet() and greet(String).
 *   - Nested class: static nested class Department.
 *   - Base version of displayDetails() that the subclasses extend.
 *
 * Student, Faculty, Administrator (child classes)
 *   - Inheritance: each one reuses name, age and the Person methods (single-level hierarchy).
 *   - Constructors with super(name, age) to initialize the parent part.
 *   - Method overriding: each overrides displayDetails() and calls super.displayDetails().
 *   - Own extra fields (USN/semester, designation, office) and use of the nested Department class
 *     (Student and Faculty).
 *
 * Main
 *   - Run-time polymorphism: Person[] array holding Student, Faculty and Administrator objects;
 *     p.displayDetails() calls the correct overriding method for each object.
 */
