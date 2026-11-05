/*
 * Chapter 1 | Program 4: Student result system using classes and objects
 */

// Object that holds a student's result summary (returned by Student.getResultSummary())
class ResultSummary {
    private final String usn;
    private final String name;
    private final int total;
    private final double average;
    private final String grade;

    ResultSummary(String usn, String name, int total, double average, String grade) {
        this.usn = usn;
        this.name = name;
        this.total = total;
        this.average = average;
        this.grade = grade;
    }

    void display() {
        System.out.printf("Summary -> USN: %s | Name: %s | Total: %d | Average: %.2f | Class: %s%n",
                usn, name, total, average, grade);
    }
}

class Student {
    // static: one shared counter for all students
    private static int studentCount = 0;

    // final: value can never change after it is set (static final = constant)
    public static final int MAX_MARKS = 100;

    // private fields: cannot be accessed directly from outside the class
    private final String usn;
    private String name;
    private int[] marks = new int[3];

    Student(String usn, String name, int m1, int m2, int m3) {
        this.usn = usn;
        this.name = name;
        this.marks[0] = validateMark(m1);   // invalid marks are rejected
        this.marks[1] = validateMark(m2);
        this.marks[2] = validateMark(m3);
        studentCount++;                      // counted only if creation succeeded
    }

    // validation method that protects the marks
    static int validateMark(int mark) {
        if (mark < 0 || mark > MAX_MARKS) {
            throw new IllegalArgumentException(
                    "Invalid marks " + mark + " (allowed range: 0 to " + MAX_MARKS + ")");
        }
        return mark;
    }

    // getters
    String getUsn() {
        return usn;
    }

    String getName() {
        return name;
    }

    int getMark(int subjectNumber) {      // subjectNumber = 1, 2 or 3
        return marks[subjectNumber - 1];
    }

    static int getStudentCount() {
        return studentCount;
    }

    int calculateTotal() {
        return marks[0] + marks[1] + marks[2];
    }

    double calculateAverage() {
        return calculateTotal() / 3.0;
    }

    String findClass() {
        double avg = calculateAverage();
        if (avg >= 75) return "Distinction";
        if (avg >= 60) return "First Class";
        if (avg >= 40) return "Pass";
        return "Fail";
    }

    // Overloaded display(): version 1 prints basic details
    void display() {
        System.out.println("USN: " + usn + " | Name: " + name);
    }

    // Overloaded display(): version 2 prints the result
    void display(boolean showResult) {
        display();
        if (showResult) {
            System.out.println("  Marks   : " + marks[0] + ", " + marks[1] + ", " + marks[2]);
            System.out.println("  Total   : " + calculateTotal() + " / " + (3 * MAX_MARKS));
            System.out.printf("  Average : %.2f%n", calculateAverage());
            System.out.println("  Result  : " + findClass());
        }
    }

    // Returns a NEW object containing the result summary
    ResultSummary getResultSummary() {
        return new ResultSummary(usn, name, calculateTotal(), calculateAverage(), findClass());
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("1CI24CS001", "Ananya", 85, 78, 92);
        Student s2 = new Student("1CI24CS002", "Rahul", 55, 62, 48);

        System.out.println("--- Basic details (display()) ---");
        s1.display();
        s2.display();

        System.out.println("\n--- Result (display(true)) ---");
        s1.display(true);
        s2.display(true);

        System.out.println("\n--- Result summary object ---");
        ResultSummary summary = s1.getResultSummary();
        summary.display();

        System.out.println("\n--- Validation test ---");
        try {
            new Student("1CI24CS003", "Invalid", 105, 50, 60);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        System.out.println("\nTotal students created: " + Student.getStudentCount());
    }
}

/*
 * CHALLENGE
 * Why is static suitable for the student count?
 *   The count belongs to the CLASS as a whole, not to any single student. A static variable has
 *   exactly one copy shared by all objects, so every constructor call increments the same
 *   counter, and it can be read without creating an object (Student.getStudentCount()).
 *   An instance variable would give each student its own separate counter (always 1).
 *
 * Why can the maximum marks value be final?
 *   The maximum marks per subject is a fixed rule (100) that must never change while the
 *   program runs. Declaring it final makes the compiler reject any attempt to modify it, which
 *   protects the validation logic. Making it static final means a single shared constant
 *   instead of one copy per student.
 */
