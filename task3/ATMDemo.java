public class ATMDemo {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00); // Set initial balance
        ATM atm = new ATM(account);
        atm.run();
    }
}
