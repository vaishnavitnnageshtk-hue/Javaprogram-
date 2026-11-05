/*
 * OOPS Programming - I | Q4
 * WAP to create class BankAccount. Deposit an amount, withdraw an amount
 * and check the balance. Fields: accountHolderName and balance.
 */
class BankAccount {
    String accountHolderName;
    double balance;

    BankAccount(String accountHolderName, double balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount: " + amount);
            return;
        }
        balance += amount;
        System.out.println("Deposited " + amount + ".");
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount: " + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance! Cannot withdraw " + amount);
        } else {
            balance -= amount;
            System.out.println("Withdrew " + amount + ".");
        }
    }

    void checkBalance() {
        System.out.println("Account holder: " + accountHolderName + " | Balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Ananya Sharma", 5000);

        acc.checkBalance();
        acc.deposit(2500);
        acc.checkBalance();
        acc.withdraw(1000);
        acc.checkBalance();
        acc.withdraw(10000);   // more than the balance -> rejected
        acc.deposit(-50);      // negative -> rejected
        acc.checkBalance();
    }
}
