package BankAccount;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private Amount balance;
    private final List<String> history = new ArrayList<>();
    private final StringBuilder statement = new StringBuilder();


    public BankAccount() {
        this.balance = new Amount(0);
    }

    public BankAccount(Amount balance) {
        this.balance = balance;
        recordStatement("DEPOSIT", balance);
    }

    public Amount getBalance() {
        return this.balance;
    }

    public void deposit(Amount amount) {
        String deposit = "DEPOSIT";
        this.balance = this.balance.add(amount);
        recordStatement(deposit, amount);
    }

    private void recordStatement(String type, Amount amount) {
        statement
                .append(type)
                .append(", ")
                .append("08/02/2022")
                .append(", ")
                .append(amount.value())
                .append(", ")
                .append(balance.value());
    }

    public void withdrawal(Amount amount) {
        this.balance = this.balance.subtract(amount);
    }

    public List<String> history() {
        if (balance.value() > 0)
            history.add(statement.toString());
        return history;
    }
}
