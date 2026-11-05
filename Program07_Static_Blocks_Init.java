/*
 * Chapter 1 | Program 7 (Output tracing): Static variables, static blocks
 * and object initialization
 */
class Counter {
    static int count = 0;
    int id;

    static {
        System.out.println("Static block");
    }

    {
        count++;
        id = count;
        System.out.println("Instance block: " + id);
    }

    Counter() {
        System.out.println("Constructor: " + id);
    }
}

public class Main {
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        System.out.println(Counter.count);
    }
}

/*
 * PREDICTED OUTPUT:
 *   Static block
 *   Instance block: 1
 *   Constructor: 1
 *   Instance block: 2
 *   Constructor: 2
 *   2
 *
 * ANSWERS
 * 1. How many times does the static block execute?
 *    Exactly ONCE. It runs when the class Counter is loaded (at the first use of the class,
 *    here the first "new Counter()"), before any object is created.
 *
 * 2. How many times does the instance initialization block execute?
 *    Once for EVERY object created. Two objects -> 2 times.
 *
 * 3. In what order do the initialization block and constructor execute?
 *    For each new object: instance initialization block FIRST, then the constructor body.
 *    That is why "Instance block: 1" is printed before "Constructor: 1", and why id already
 *    has its value when the constructor prints it.
 *
 * 4. What is the final value of count?
 *    2. count is static (one shared copy) and is incremented once per object created.
 */
