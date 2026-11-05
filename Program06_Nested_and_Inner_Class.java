/*
 * Chapter 1 | Program 6: Nested class and inner class
 */
class University {
    private String universityName;

    University(String universityName) {
        this.universityName = universityName;
    }

    // Outer-class method
    void displayUniversityInfo() {
        System.out.println("University: " + universityName);
    }

    // STATIC NESTED class: does not need an University object
    static class Department {
        private String departmentName;

        Department(String departmentName) {
            this.departmentName = departmentName;
        }

        void display() {
            System.out.println("Department: " + departmentName);
        }
    }

    // NON-STATIC INNER class: every Faculty object belongs to one University object
    class Faculty {
        private String facultyName;
        private String designation;

        Faculty(String facultyName, String designation) {
            this.facultyName = facultyName;
            this.designation = designation;
        }

        void display() {
            // can directly use the outer object's field universityName
            System.out.println("Faculty: " + facultyName + " (" + designation + ") works at " + universityName);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        University uni = new University("Visvesvaraya Technological University");

        // Static nested class: created WITHOUT any University object
        University.Department dept = new University.Department("Computer Science and Engineering");

        // Inner class: needs an enclosing University object -> uni.new Faculty(...)
        University.Faculty faculty = uni.new Faculty("Dr. Meera Rao", "Professor");

        uni.displayUniversityInfo();
        dept.display();
        faculty.display();
    }
}

/*
 * CHALLENGE: Why does a non-static inner class need an enclosing outer-class instance,
 * while a static nested class does not?
 *
 * - A non-static inner class is an INSTANCE member of the outer class, like a field or a method.
 *   Every inner-class object holds a hidden reference to the outer object that created it
 *   (University.this), which is how Faculty can read universityName directly. Without an outer
 *   object that reference would have nothing to point to, so the compiler requires one:
 *   uni.new Faculty(...).
 *
 * - A static nested class is a STATIC member: it belongs to the outer CLASS, not to any
 *   object. It has no hidden outer reference and cannot use the outer class's instance
 *   fields directly, so it can be created on its own: new University.Department(...).
 */
