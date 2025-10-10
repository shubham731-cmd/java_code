import java.util.Scanner;

public class CreateYourOwnMiniATM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        int[] userPins = {1234, 2345, 3456, 4567, 5678};
        double[] balances = {5000, 10000, 7500, 12000, 3000};

        int maxAttempts = 3;

        System.out.println("Welcome to the ATM!");

    
        int attempts = 0;
        int userIndex = -1;

        while (attempts < maxAttempts) {
            System.out.print("Enter your 4-digit PIN: ");
            int pin = sc.nextInt();

        
            boolean valid = false;
            for (int i = 0; i < userPins.length; i++) {
                if (pin == userPins[i]) {
                    valid = true;
                    userIndex = i;
                    break;
                }
            }

            if (valid) {
                System.out.println("Login successful!");
                break;
            } else {
                attempts++;
                System.out.println("Invalid PIN. Attempts left: " + (maxAttempts - attempts));
            }
        }

        if (userIndex == -1) {
            System.out.println("Too many failed attempts. Exiting...");
            sc.close();
            return;
        }

        
        while (true) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Your balance: ₹" + balances[userIndex]);
            } else if (choice == 2) {
                System.out.print("Enter deposit amount: ");
                double amount = sc.nextDouble();
                if (amount > 0) {
                    balances[userIndex] += amount;
                    System.out.println("Deposited ₹" + amount + ". New balance: ₹" + balances[userIndex]);
                } else {
                    System.out.println("Invalid amount!");
                }
            } else if (choice == 3) {
                System.out.print("Enter withdrawal amount: ");
                double amount = sc.nextDouble();
                if (amount > 0 && amount <= balances[userIndex]) {
                    balances[userIndex] -= amount;
                    System.out.println("Withdrawn ₹" + amount + ". Remaining balance: ₹" + balances[userIndex]);
                } else {
                    System.out.println("Insufficient balance or invalid amount!");
                }
            } else if (choice == 4) {
                System.out.println("Thank you for using the ATM!");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
