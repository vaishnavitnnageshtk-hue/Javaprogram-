/*
 * OOPS Programming - I | Q3
 * WAP to create class Circle and calculate the area and circumference
 * of the circle with related fields and methods.
 */
class Circle {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;          // pi * r^2
    }

    double calculateCircumference() {
        return 2 * Math.PI * radius;               // 2 * pi * r
    }
}

public class Main {
    public static void main(String[] args) {
        Circle c1 = new Circle(7);
        Circle c2 = new Circle(3.5);

        System.out.println("Circle 1 (radius = " + c1.radius + ")");
        System.out.printf("  Area          = %.2f%n", c1.calculateArea());
        System.out.printf("  Circumference = %.2f%n", c1.calculateCircumference());

        System.out.println("Circle 2 (radius = " + c2.radius + ")");
        System.out.printf("  Area          = %.2f%n", c2.calculateArea());
        System.out.printf("  Circumference = %.2f%n", c2.calculateCircumference());
    }
}
