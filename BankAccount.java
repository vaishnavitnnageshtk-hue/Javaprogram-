/*
 * Chapter 1 | Program 5: Bank account with access control
 * File 1 of 2: BankAccount.java  (the test class is in BankTest.java)
 */
public class BankAccount {
    // static: one shared counter for all accounts
    private static int accountCount = 0;

    // final: the identifier is assigned once in the constructor and can never change
    private final int accountId;

    // private: cannot be accessed directly from outside this class
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double openingBalance) {
        accountCount++;
        this.accountId = 1000 + accountCount;      // assigned exactly once
        this.accountNumber = accountNumber;
        this.balance = (openingBalance < 0) ? 0 : openingBalance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected: amount must be positive (got " + amount + ")");
            return false;
        }
        balance += amount;
        System.out.println("Deposited " + amount + " into " + accountNumber);
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal rejected: invalid amount (" + amount + ")");
            return false;
        }
        if (amount > balance) {
            System.out.println("Withdrawal rejected: insufficient balance (balance " + balance
                    + ", requested " + amount + ")");
            return false;
        }
        balance -= amount;
        System.out.println("Withdrew " + amount + " from " + accountNumber);
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public static int getAccountCount() {
        return accountCount;
    }
}
