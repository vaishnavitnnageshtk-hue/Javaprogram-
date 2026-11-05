/*
 * OOPS Programming - I | Q2
 * WAP to create Rectangle class and calculate the area of the rectangle.
 * Declare the fields and related method like CalculateArea().
 */
class Rectangle {
    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double CalculateArea() {
        return length * width;
    }
}

public class Main {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(10, 5);
        Rectangle r2 = new Rectangle(7.5, 4.2);

        System.out.println("Rectangle 1: length = " + r1.length + ", width = " + r1.width);
        System.out.println("Area of Rectangle 1 = " + r1.CalculateArea());

        System.out.println("Rectangle 2: length = " + r2.length + ", width = " + r2.width);
        System.out.printf("Area of Rectangle 2 = %.2f%n", r2.CalculateArea());
    }
}
