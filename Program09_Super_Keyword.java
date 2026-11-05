/*
 * Chapter 2 | Program 9 (Challenging): Using super to access fields and methods
 */
class Vehicle {
    protected String brand;

    Vehicle(String brand) {
        this.brand = brand;
    }

    void display() {
        System.out.println("Vehicle brand: " + brand);
    }
}

class Car extends Vehicle {
    protected String brand;       // child's own field: HIDES the parent's field of the same name

    Car(String vehicleBrand, String carBrand) {
        super(vehicleBrand);      // initializes the parent's brand
        this.brand = carBrand;    // initializes the child's brand
    }

    @Override
    void display() {
        super.display();          // parent's version of display()
        System.out.println("Car brand (brand / this.brand)  : " + brand);
        System.out.println("Parent brand (super.brand)      : " + super.brand);
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Maruti Suzuki", "Swift");
        car.display();
    }
}

/*
 * PREDICTED OUTPUT (the two brands have different values):
 *   Vehicle brand: Maruti Suzuki
 *   Car brand (brand / this.brand)  : Swift
 *   Parent brand (super.brand)      : Maruti Suzuki
 *
 * CHALLENGE: Difference between brand and super.brand
 *   Inside Car there are TWO separate fields called brand:
 *     - brand (same as this.brand)  -> the field declared in Car. It hides the parent's field.
 *     - super.brand                 -> the field declared in Vehicle (the parent part of the object).
 *   They are stored separately, so they can hold different values, as shown above
 *   ("Swift" and "Maruti Suzuki"). Using the plain name brand inside Car always means the
 *   child's field; super is needed to reach the hidden parent field.
 *   The first line of output comes from super.display(), which runs in Vehicle and therefore
 *   sees Vehicle's own brand.
 */
