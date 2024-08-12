import java.util.Scanner;
class BankAccount {
    private String accountHolder;
    private double balance;
    BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: \u20B9" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: \u20B9" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }
    public void checkBalance() {
        System.out.println("Current balance: \u20B9" + balance);
    }
    public String getAccountHolder() {
        return accountHolder;
    }
}
public class BankingSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static BankAccount account;
    public static void main(String[] args) {
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        account = new BankAccount(name);
        while (true) {
            System.out.println("\nBanking System");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: depositMoney(); break;
                case 2: withdrawMoney(); break;
                case 3: checkBalance(); break;
                case 4: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void depositMoney() {
        System.out.print("Enter amount to deposit (in INR): \u20B9");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        account.deposit(amount);
    }
    private static void withdrawMoney() {
        System.out.print("Enter amount to withdraw (in INR): \u20B9");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        account.withdraw(amount);
    }
    private static void checkBalance() {
        account.checkBalance();
    }
}
