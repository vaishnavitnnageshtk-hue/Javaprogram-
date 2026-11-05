/*
 * Chapter 2 | Program 8 (Medium): Employee salary calculation
 */
class Employee {
    protected int empId;
    protected String name;
    protected double basicSalary;

    Employee(int empId, String name, double basicSalary) {
        this.empId = empId;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    // Overridden in the subclasses
    double calculateSalary() {
        return basicSalary;
    }

    void display() {
        System.out.println("ID: " + empId + " | Name: " + name + " | Basic Salary: " + basicSalary);
        System.out.printf("Calculated Salary: %.2f%n", calculateSalary());
    }
}

class PermanentEmployee extends Employee {
    private static final double ALLOWANCE = 5000;   // fixed allowance
    private double bonus;

    PermanentEmployee(int empId, String name, double basicSalary, double bonus) {
        super(empId, name, basicSalary);              // parent constructor
        this.bonus = bonus;
    }

    @Override
    double calculateSalary() {
        return basicSalary + ALLOWANCE + bonus;
    }

    @Override
    void display() {
        System.out.println("[Permanent Employee]");
        super.display();
        System.out.println("  (Basic + Allowance " + ALLOWANCE + " + Bonus " + bonus + ")");
    }
}

class ContractEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    ContractEmployee(int empId, String name, int hoursWorked, double hourlyRate) {
        super(empId, name, 0);                        // contract staff have no fixed basic salary
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    @Override
    void display() {
        System.out.println("[Contract Employee]");
        super.display();
        System.out.println("  (Hours " + hoursWorked + " x Rate " + hourlyRate + ")");
    }
}

public class Main {
    public static void main(String[] args) {
        PermanentEmployee pe = new PermanentEmployee(101, "Ananya", 30000, 4000);
        ContractEmployee ce = new ContractEmployee(201, "Rahul", 120, 250);

        System.out.println("--- Individual objects ---");
        pe.display();
        System.out.println();
        ce.display();

        // CHALLENGE: Employee[] array holding both types; same call, different behaviour
        System.out.println("\n--- Employee[] array and calculateSalary() for every element ---");
        Employee[] employees = {pe, ce, new PermanentEmployee(102, "Priya", 45000, 6000)};
        for (Employee e : employees) {
            System.out.printf("%s (ID %d) -> Salary = %.2f%n", e.name, e.empId, e.calculateSalary());
        }
    }
}
