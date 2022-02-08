package BankAccount;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private Amount balance;
    private final List<String> history = new ArrayList<>();
    private StringBuilder statement;


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

    public void withdrawal(Amount amount) {
        String withdrawal = "WITHDRAWAL";
        this.balance = this.balance.subtract(amount);
        recordStatement(withdrawal, amount);

    }

    private void recordStatement(String type, Amount amount) {
        statement =  new StringBuilder()
                .append(type)
                .append(", ")
                .append("08/02/2022")
                .append(", ")
                .append(amount.value())
                .append(", ")
                .append(balance.value());

        history.add(statement.toString());
    }

    public List<String> history() {
        return history;
    }
}
