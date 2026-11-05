/*
 * Chapter 2 | Program 13 (Advanced): Overriding, overloading and inheritance together
 */
class Payment {
    // Method that subclasses OVERRIDE
    double calculateAmount(double amount) {
        return amount;                                   // no fee for a plain payment
    }

    // OVERLOADED version (same name, different parameters): applies a discount first
    double calculateAmount(double amount, double discountPercent) {
        double discounted = amount - (amount * discountPercent / 100);
        return calculateAmount(discounted);              // runs the overridden version of the actual object
    }

    // private method: not inherited, so it cannot be overridden
    private String info() {
        return "Payment.info() (private)";
    }

    void showInfo() {
        System.out.println(info());                      // always calls Payment's own private info()
    }

    // final method: subclasses are not allowed to override it
    final void printReceipt(double paid) {
        System.out.println("Receipt: amount paid = " + paid);
    }
}

class CardPayment extends Payment {
    // Fee rule: 2% card processing fee
    @Override
    double calculateAmount(double amount) {
        return amount + amount * 0.02;
    }

    // Same name as Payment's private info(), but it is a NEW, unrelated method - not an override
    private String info() {
        return "CardPayment.info() (private, not an override)";
    }
}

class UPIPayment extends Payment {
    // Fee rule: free up to Rs.1000, 0.5% above that
    @Override
    double calculateAmount(double amount) {
        return (amount <= 1000) ? amount : amount + amount * 0.005;
    }

    // void printReceipt(double paid) { }   // COMPILE ERROR: cannot override final method
}

public class Main {
    public static void main(String[] args) {
        // Parent reference, child objects
        Payment p1 = new CardPayment();
        Payment p2 = new UPIPayment();

        double amount = 5000;

        System.out.println("--- Overridden method via parent reference (run-time choice) ---");
        System.out.printf("Card payment of %.2f -> %.2f%n", amount, p1.calculateAmount(amount));
        System.out.printf("UPI payment  of %.2f -> %.2f%n", amount, p2.calculateAmount(amount));

        System.out.println("\n--- Overloaded method with 10% discount ---");
        System.out.printf("Card payment with discount -> %.2f%n", p1.calculateAmount(amount, 10));
        System.out.printf("UPI payment  with discount -> %.2f%n", p2.calculateAmount(amount, 10));

        System.out.println("\n--- Private method is NOT overridden ---");
        p1.showInfo();

        System.out.println("\n--- Final method is shared by all ---");
        p1.printReceipt(p1.calculateAmount(amount));
    }
}

/*
 * COMPILE TIME vs RUN TIME
 *   p1.calculateAmount(amount)       - COMPILE TIME: the compiler checks that Payment has a method
 *                                      calculateAmount(double) and fixes the signature.
 *                                    - RUN TIME: the JVM sees the object is a CardPayment, so it
 *                                      runs CardPayment's version (UPIPayment's for p2).
 *   p1.calculateAmount(amount, 10)   - COMPILE TIME: overload resolution picks the two-parameter
 *                                      method (decided by the number/types of arguments).
 *                                    - RUN TIME: that method is inherited from Payment, and inside it
 *                                      the call calculateAmount(discounted) is dispatched to the
 *                                      overriding method of the actual object.
 *   Rule of thumb: OVERLOADING is resolved at compile time; OVERRIDING at run time.
 *
 * CHALLENGE
 * Can you override a private method?
 *   No. A private method is not visible to (not inherited by) subclasses, so a subclass method with
 *   the same name is a completely separate method. Proof in this program: p1.showInfo() prints
 *   "Payment.info() (private)", not CardPayment's info(), even though p1 refers to a CardPayment.
 *
 * Can you override a final method?
 *   No. final means "this implementation cannot be changed". Trying to override printReceipt()
 *   in a subclass gives a compile-time error ("cannot override ... overridden method is final").
 */
