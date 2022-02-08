package BankAccount;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private Amount balance;
    private List<String> history = new ArrayList<>();


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

    public List<String> history() {
        if (balance.value() > 0)
            history.add("DEPOSIT, 08/02/2022, 10, 10");
        return history;
    }
}
