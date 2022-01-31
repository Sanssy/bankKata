package BankAccount;

public class BankAccount {
    private Amount balance;

    public BankAccount() {
        this.balance = new Amount(0);
    }

    public BankAccount(Amount balance) {
        this.balance = balance;
    }

    public Amount getBalance() {
        return this.balance;
    }

    public void deposit(Amount amount) {
        this.balance = this.balance.add(amount);
    }

    public void withdrawal(Amount amount) {
        this.balance = this.balance.subtract(amount);
    }
}
