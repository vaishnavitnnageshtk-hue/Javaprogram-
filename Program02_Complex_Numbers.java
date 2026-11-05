/*
 * Chapter 1 | Program 2 (Challenging): Objects as parameters and returning objects
 */
class Complex {
    private double real;
    private double imag;

    Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    // Object as parameter, new object returned
    Complex add(Complex c) {
        return new Complex(this.real + c.real, this.imag + c.imag);
    }

    // (a + bi)(c + di) = (ac - bd) + (ad + bc)i
    Complex multiply(Complex c) {
        double r = this.real * c.real - this.imag * c.imag;
        double i = this.real * c.imag + this.imag * c.real;
        return new Complex(r, i);
    }

    double magnitude() {
        return Math.sqrt(real * real + imag * imag);
    }

    // returns 1 if this is larger, -1 if smaller, 0 if equal
    int compareMagnitude(Complex c) {
        return Double.compare(this.magnitude(), c.magnitude());
    }

    // returns a brand new object with the same values
    Complex copy() {
        return new Complex(real, imag);
    }

    void setReal(double real) {
        this.real = real;
    }

    void setImag(double imag) {
        this.imag = imag;
    }

    void display() {
        String sign = imag < 0 ? "-" : "+";
        System.out.printf("%.2f %s %.2fi%n", real, sign, Math.abs(imag));
    }
}

public class Main {
    public static void main(String[] args) {
        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(1, -2);

        System.out.print("c1 = ");
        c1.display();
        System.out.print("c2 = ");
        c2.display();

        System.out.print("c1 + c2 = ");
        c1.add(c2).display();

        System.out.print("c1 * c2 = ");
        c1.multiply(c2).display();

        System.out.printf("|c1| = %.2f, |c2| = %.2f%n", c1.magnitude(), c2.magnitude());
        int result = c1.compareMagnitude(c2);
        if (result > 0) {
            System.out.println("c1 has the larger magnitude");
        } else if (result < 0) {
            System.out.println("c2 has the larger magnitude");
        } else {
            System.out.println("Both have equal magnitude");
        }

        // CHALLENGE: modify an object after copying it; the copy must remain unchanged
        System.out.println("\n--- Copy test ---");
        Complex copyOfC1 = c1.copy();
        c1.setReal(100);
        c1.setImag(200);

        System.out.print("c1 (modified)  = ");
        c1.display();
        System.out.print("copy of c1     = ");
        copyOfC1.display();
        System.out.println("The copy is unchanged because copy() created a separate object in memory.");
    }
}
