/*
 * Chapter 1 | Program 3 (Challenging): Understanding argument passing in Java
 */
class Student {
    int marks;

    Student(int marks) {
        this.marks = marks;
    }
}

public class Main {
    static void change(int x, Student s) {
        x = 100;                   // changes only the local copy of n
        s.marks = 95;              // changes the real object (s and st point to the same object)
        s = new Student(50);       // s now points to a new object; st is not affected
    }

    public static void main(String[] args) {
        int n = 20;
        Student st = new Student(60);

        change(n, st);

        System.out.println(n);
        System.out.println(st.marks);
    }
}

/*
 * PREDICTED OUTPUT:
 *   20
 *   95
 *
 * ANSWERS
 * 1. Why does n retain its original value?
 *    n is a primitive. Java copies its VALUE (20) into the parameter x. The method changes
 *    only that copy, so the original n in main() stays 20.
 *
 * 2. Why does st.marks change?
 *    For objects, what is copied is the REFERENCE (the address of the object). s and st both
 *    refer to the SAME Student object, so s.marks = 95 changes the one shared object.
 *
 * 3. Why does s = new Student(50) not change which object st refers to?
 *    s is only a local copy of the reference. Assigning a new object to s makes the local
 *    variable point somewhere else; the variable st in main() still holds the old address.
 *    (The new Student(50) object is lost when the method ends.)
 *
 * 4. Is Java pass-by-value or pass-by-reference?
 *    Java is ALWAYS pass-by-value. For primitives the value is the data itself; for objects
 *    the value is a copy of the reference. That is why the object's contents can be changed
 *    through the copy, but the caller's reference cannot be re-pointed.
 */
