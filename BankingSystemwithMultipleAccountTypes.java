import java.util.*;
// Customer class (Composition)
class Customer {
    private String name;
    private String customerId;

    Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }
}

// Abstract Account class (Abstraction + Encapsulation)
abstract class Account {
    private double balance;      // Encapsulation: balance is private
    private Customer customer;   // Composition: Customer owns the account

    Account(Customer customer, double initialBalance) {
        this.customer = customer;
        this.balance = initialBalance;
    }

    // Deposit money (common to all accounts)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + ". Current Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw money (Polymorphism: overridden in child classes)
    public abstract void withdraw(double amount);

    // Calculate interest (Polymorphism)
    public abstract void calculateInterest();

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Setter for balance (for internal use)
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }
}

// SavingsAccount class (Inheritance)
class SavingsAccount extends Account {
    private double interestRate = 0.04; // 4% annual

    SavingsAccount(Customer customer, double initialBalance) {
        super(customer, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawn " + amount + ". Current Balance: " + getBalance());
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    @Override
    public void calculateInterest() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
        System.out.println("Interest added: " + interest + ". New Balance: " + getBalance());
    }
}

// CurrentAccount class (Inheritance)
class CurrentAccount extends Account {
    private double overdraftLimit = 5000; // allowed negative balance

    CurrentAccount(Customer customer, double initialBalance) {
        super(customer, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance() + overdraftLimit) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawn " + amount + ". Current Balance: " + getBalance());
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
    }

    @Override
    public void calculateInterest() {
        System.out.println("Current accounts do not earn interest.");
    }
}

// FixedDeposit class (Inheritance)
class FixedDeposit extends Account {
    private int months; // deposit duration
    private double interestRate = 0.06; // 6% annual

    FixedDeposit(Customer customer, double initialBalance, int months) {
        super(customer, initialBalance);
        this.months = months;
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Cannot withdraw before maturity!");
    }

    @Override
    public void calculateInterest() {
        double interest = getBalance() * interestRate * months / 12;
        setBalance(getBalance() + interest);
        System.out.println("Interest for " + months + " months added: " + interest +
                           ". New Balance: " + getBalance());
    }
}

// Main class
//import java.util.Scanner;

public class BankingSystemwithMultipleAccountTypes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create customers
        Customer c1 = new Customer("Shubham", "C001 ");
        Customer c2 = new Customer("Neha", "C002 ");

        // Create accounts
        Account a1 = new SavingsAccount(c1, 10000);
        Account a2 = new CurrentAccount(c2, 5000);
        Account a3 = new FixedDeposit(c1, 20000, 12);

        // Simple menu
        while (true) {
            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Calculate Interest");
            System.out.println("4. Show Balance");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            System.out.print("Select account (1-Savings, 2-Current, 3-FD): ");
            int accChoice = sc.nextInt();

            Account selected = (accChoice == 1) ? a1 : (accChoice == 2) ? a2 : a3;

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    selected.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double w = sc.nextDouble();
                    selected.withdraw(w);
                    break;
                case 3:
                    selected.calculateInterest();
                    break;
                case 4:
                    System.out.println("Current Balance: " + selected.getBalance());
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
