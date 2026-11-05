/*
 * Chapter 2 | Program 11 (Output tracing): Constructor execution in an inheritance hierarchy
 *
 * PART 1: the original program (A <- B <- C)
 * PART 2: modified so every constructor accepts an int and passes a different value
 *         to its parent using super(value)
 */

// ----- PART 1 : original program -----
class A {
    A() {
        System.out.println("A constructor");
    }
}

class B extends A {
    B() {
        System.out.println("B constructor");
    }
}

class C extends B {
    C() {
        System.out.println("C constructor");
    }
}

// ----- PART 2 : modified with int parameters and super(value) -----
class A2 {
    A2(int value) {
        System.out.println("A2 constructor, received value = " + value);
    }
}

class B2 extends A2 {
    B2(int value) {
        super(value + 5);       // passes a different value (value + 5) to A2
        System.out.println("B2 constructor, received value = " + value);
    }
}

class C2 extends B2 {
    C2(int value) {
        super(value * 2);       // passes a different value (value * 2) to B2
        System.out.println("C2 constructor, received value = " + value);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Part 1: new C() ===");
        C obj = new C();

        System.out.println("\n=== Part 2: new C2(1) ===");
        C2 obj2 = new C2(1);
    }
}

/*
 * PREDICTED OUTPUT of Part 1:
 *   A constructor
 *   B constructor
 *   C constructor
 * Reason: C() has an invisible super() as its first statement, which runs B(); B() has an
 * invisible super() that runs A(). So the parent constructors finish first: A, then B, then C.
 *
 * OUTPUT of Part 2 (new C2(1)):
 *   A2 constructor, received value = 7     (C2 gets 1 -> passes 1*2 = 2 to B2 -> B2 passes 2+5 = 7 to A2)
 *   B2 constructor, received value = 2
 *   C2 constructor, received value = 1
 *
 * CHALLENGE: What happens if super() or super(value) is placed after an ordinary statement
 * in a constructor?
 *   In standard Java (Java 21 and earlier) it is a COMPILE-TIME ERROR:
 *   "call to super must be first statement in constructor".
 *   Example that does NOT compile:
 *       C2(int value) {
 *           System.out.println("hello");   // ordinary statement first
 *           super(value * 2);              // ERROR
 *       }
 *   Reason: the parent part of the object must be fully built before the child's code runs,
 *   so super(...) (or this(...)) must be the very first statement. If you do not write it, the
 *   compiler inserts super() automatically.
 *   (Very recent Java versions relax this slightly and allow statements that do not use
 *   'this' before super(...), but for exams and labs the answer is: it must be the first statement.)
 */
