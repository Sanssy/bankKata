public class BankAccount {
    private int balance;

    public BankAccount() {
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }
}
