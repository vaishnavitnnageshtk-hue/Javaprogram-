/*
 * Chapter 2 | Program 12 (Challenging): Method overriding with run-time polymorphism
 */
class Shape {
    double area() {
        return 0;
    }
}

class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double area() {
        return 0.5 * base * height;
    }
}

public class Main {
    public static void main(String[] args) {
        // Array of Shape references holding objects of all three subclasses
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(7);
        shapes[1] = new Rectangle(5, 4);
        shapes[2] = new Triangle(6, 3);

        String[] names = {"Circle (r = 7)", "Rectangle (5 x 4)", "Triangle (b = 6, h = 3)"};

        for (int i = 0; i < shapes.length; i++) {
            // same call shapes[i].area(), different code runs for each object
            System.out.printf("Area of %-25s = %.2f%n", names[i], shapes[i].area());
        }
    }
}

/*
 * CHALLENGE: Why does the method executed depend on the actual object rather than the
 * reference type?
 *   Overridden methods are bound at RUN TIME (dynamic method dispatch). The reference type
 *   (Shape) only tells the compiler that an area() method exists. When the program runs, the JVM
 *   looks at the actual object in memory (Circle, Rectangle or Triangle) and calls that class's
 *   version of area(). So the same statement shapes[i].area() produces different behaviour for
 *   different objects. This is run-time polymorphism, and it lets us add new shapes without
 *   changing the loop.
 */
