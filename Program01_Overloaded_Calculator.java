/*
 * Chapter 1 | Program 1 (Medium): Overloaded calculator using methods
 */
class Calculator {
    // 1) sum of two ints
    int calculate(int a, int b) {
        return a + b;
    }

    // 2) product of two doubles
    double calculate(double a, double b) {
        return a * b;
    }

    // 3) largest of three ints
    int calculate(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    // 4) difference (int - double) returned as double
    double calculate(int a, double b) {
        return a - b;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("calculate(10, 20)      -> sum        = " + calc.calculate(10, 20));
        System.out.println("calculate(2.5, 4.0)    -> product    = " + calc.calculate(2.5, 4.0));
        System.out.println("calculate(15, 42, 30)  -> largest    = " + calc.calculate(15, 42, 30));
        System.out.println("calculate(10, 3.5)     -> difference = " + calc.calculate(10, 3.5));

        // Extra demo: the int 4 is automatically widened to 4.0, so the (double, double) version runs
        System.out.println("calculate(2.5, 4)      -> product    = " + calc.calculate(2.5, 4));
    }
}

/*
 * CHALLENGE: How does Java select the correct overloaded method?
 *
 * Overloaded methods share a name but must differ in the NUMBER, TYPE or ORDER of
 * parameters (the return type alone is not enough). The choice is made by the
 * COMPILER at compile time (static / early binding), in this order:
 *   1. Exact match of the argument types      -> calculate(10, 3.5) picks (int, double).
 *   2. If no exact match, widening conversion -> calculate(2.5, 4) widens 4 to 4.0 and
 *      picks (double, double), because (int, double) cannot accept 2.5 (narrowing is not
 *      done automatically).
 *   3. Then boxing/unboxing, then varargs.
 *   When several methods are applicable, the MOST SPECIFIC one is chosen
 *   (calculate(10, 20) picks (int, int) rather than (double, double)).
 *   If no method fits, or two are equally specific, it is a compile-time error.
 */
