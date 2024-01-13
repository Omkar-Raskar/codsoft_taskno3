import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true; // Withdrawal successful
        }
        return false; // Withdrawal failed
    }
}

class ATMMachine {
    private BankAccount bankAccount;

    public ATMMachine(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void withdraw(double amount) {
        boolean success = bankAccount.withdraw(amount);
        if (success) {
            System.out.println("Withdrawal successful. Remaining balance: " + bankAccount.getBalance());
        } else {
            System.out.println("Withdrawal failed. Insufficient balance ");
        }
    }

    public void deposit(double amount) {
        bankAccount.deposit(amount);
        System.out.println("Deposit successful. New balance: " + bankAccount.getBalance());
    }

    public void checkBalance() {
        System.out.println("Current balance: " + bankAccount.getBalance());
    }
}

class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        BankAccount userAccount = new BankAccount(initialBalance);
        ATMMachine atmMachine = new ATMMachine(userAccount);

        int choice;
        do {
            System.out.println("\n1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    atmMachine.withdraw(withdrawAmount);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    atmMachine.deposit(depositAmount);
                    break;

                case 3:
                    atmMachine.checkBalance();
                    break;

                case 4:
                    System.out.println("Exiting ATM. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);
        
        scanner.close();
    }
}

