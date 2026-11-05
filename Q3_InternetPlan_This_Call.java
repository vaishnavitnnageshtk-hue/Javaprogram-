/*
 * Constructors | Q3
 * WAP to create an InternetPlan class with multiple constructors and
 * use this() to call one constructor from another.
 *
 * Constructor chaining: the shorter constructors fill in default values and
 * call the full constructor using this(...). this(...) must be the FIRST
 * statement in a constructor.
 */
class InternetPlan {
    private String planName;
    private int speedMbps;
    private int dataLimitGB;
    private double monthlyPrice;

    // Full constructor: all the real work happens here
    InternetPlan(String planName, int speedMbps, int dataLimitGB, double monthlyPrice) {
        this.planName = planName;
        this.speedMbps = speedMbps;
        this.dataLimitGB = dataLimitGB;
        this.monthlyPrice = monthlyPrice;
        System.out.println("  [Full constructor called]");
    }

    // 3 arguments: default price
    InternetPlan(String planName, int speedMbps, int dataLimitGB) {
        this(planName, speedMbps, dataLimitGB, 499.0);
        System.out.println("  [3-argument constructor called]");
    }

    // 2 arguments: default data limit
    InternetPlan(String planName, int speedMbps) {
        this(planName, speedMbps, 100);
        System.out.println("  [2-argument constructor called]");
    }

    // No arguments: default plan
    InternetPlan() {
        this("Basic", 50);
        System.out.println("  [No-argument constructor called]");
    }

    void display() {
        System.out.println("  Plan: " + planName + " | Speed: " + speedMbps + " Mbps | Data: "
                + dataLimitGB + " GB | Price: Rs." + monthlyPrice + "/month");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Creating plan with no arguments:");
        InternetPlan p1 = new InternetPlan();
        p1.display();

        System.out.println("\nCreating plan with 2 arguments:");
        InternetPlan p2 = new InternetPlan("Standard", 100);
        p2.display();

        System.out.println("\nCreating plan with 3 arguments:");
        InternetPlan p3 = new InternetPlan("Premium", 300, 500);
        p3.display();

        System.out.println("\nCreating plan with 4 arguments:");
        InternetPlan p4 = new InternetPlan("Ultra", 1000, 2000, 1499.0);
        p4.display();
    }
}
