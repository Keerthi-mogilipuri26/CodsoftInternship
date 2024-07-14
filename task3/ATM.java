import java.util.Scanner;

public class ATM {

    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw Cash");
            System.out.println("2. Deposit Cash");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    withdrawCash(scanner); // Pass scanner as argument
                    break;
                case 2:
                    depositCash(scanner); // Pass scanner as argument
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM! Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close(); // Close scanner outside the loop (optional)
    }

    private void withdrawCash(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Please collect your cash.");
            System.out.println("Your current balance is: " + account.getBalance());
        } else {
            System.out.println("Insufficient funds. Please try a lower amount.");
        }
    }

    private void depositCash(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        account.deposit(amount);
        System.out.println("Deposit successful. Your new balance is: " + account.getBalance());
    }

    private void checkBalance() {
        System.out.println("Your current balance is: " + account.getBalance());
    }
}
