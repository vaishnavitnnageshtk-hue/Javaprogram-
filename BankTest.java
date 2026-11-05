/*
 * Chapter 1 | Program 5: Bank account with access control
 * File 2 of 2: BankTest.java  (run THIS class: java BankTest)
 */
public class BankTest {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("ACC-001", 5000);
        BankAccount acc2 = new BankAccount("ACC-002", 1000);

        System.out.println("Account 1 id = " + acc1.getAccountId() + ", balance = " + acc1.getBalance());
        System.out.println("Account 2 id = " + acc2.getAccountId() + ", balance = " + acc2.getBalance());

        System.out.println("\n--- Valid operations ---");
        acc1.deposit(2000);
        acc1.withdraw(500);
        System.out.println("Balance now: " + acc1.getBalance());

        System.out.println("\n--- Invalid operations (all rejected) ---");
        acc1.deposit(-100);          // negative deposit
        acc1.withdraw(-50);          // invalid withdrawal
        acc1.withdraw(100000);       // more than the balance
        System.out.println("Balance unchanged: " + acc1.getBalance());

        System.out.println("\nTotal accounts created: " + BankAccount.getAccountCount());

        // CHALLENGE (d): a final reference
        final BankAccount fixedRef = new BankAccount("ACC-003", 100);
        fixedRef.deposit(50);        // allowed: the OBJECT can change its state
        System.out.println("fixedRef balance = " + fixedRef.getBalance());
        // fixedRef = acc1;          // COMPILE ERROR: cannot assign a value to final variable fixedRef

        // CHALLENGE (a): direct access to balance
        // System.out.println(acc1.balance);   // COMPILE ERROR: balance has private access in BankAccount
    }
}

/*
 * CHALLENGE ANSWERS
 *
 * a) Try accessing balance directly from BankTest. What happens?
 *    The line  acc1.balance  gives a compile-time error:
 *    "balance has private access in BankAccount". The program will not compile
 *    until that line is removed.
 *
 * b) Why does private protect the balance?
 *    A private member is visible only inside its own class. The only way to change the balance
 *    is through deposit() and withdraw(), and those methods run the validation checks
 *    (no negative deposits, no overdrafts). Outside code cannot bypass them and set the
 *    balance to any random value. This is encapsulation.
 *
 * c) Why is static appropriate for counting accounts?
 *    The number of accounts belongs to the class, not to one account. A static variable has a
 *    single copy shared by all objects, so each constructor call increments the same counter.
 *
 * d) Can a final reference to a BankAccount object refer to a different object later?
 *    No. A final reference variable can be assigned only once; pointing it at another object
 *    gives a compile error. However, final does NOT make the object itself unchangeable:
 *    the object's state can still change (e.g. fixedRef.deposit(50) works).
 */
