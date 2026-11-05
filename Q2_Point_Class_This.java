/*
 * Constructors | Q2
 * WAP to create a Point class to represent a point on a 2D coordinate
 * system using a constructor and the 'this' keyword.
 *
 * 'this' is used here to separate the field x from the parameter x
 * (both have the same name), and to return the current object.
 */
class Point {
    private int x;
    private int y;

    // Parameter names are same as field names -> 'this' refers to the fields
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Default constructor: origin (0, 0), reusing the other constructor via this(...)
    Point() {
        this(0, 0);
    }

    // Moves the point and returns the same object ('this') so calls can be chained
    Point move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
        return this;
    }

    double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    double distanceTo(Point other) {
        int dx = this.x - other.x;
        int dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    void display() {
        System.out.println("Point(" + x + ", " + y + ")");
    }
}

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(3, 4);
        Point p2 = new Point();          // origin

        System.out.print("p1 = ");
        p1.display();
        System.out.print("p2 = ");
        p2.display();

        System.out.printf("Distance of p1 from origin = %.2f%n", p1.distanceFromOrigin());
        System.out.printf("Distance between p1 and p2 = %.2f%n", p1.distanceTo(p2));

        p2.move(6, 8).move(1, 1);        // chaining works because move() returns 'this'
        System.out.print("p2 after moving = ");
        p2.display();
    }
}
