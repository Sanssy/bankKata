package BankAccount;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private Amount balance = new Amount(0);
    private final List<String> history = new ArrayList<>();
    private StringBuilder statement;


    public BankAccount() {
    }

    public BankAccount(Amount amount) {
        deposit(amount);
    }

    public Amount getBalance() {
        return this.balance;
    }

    public void deposit(Amount amount) {
        this.balance = this.balance.add(amount);
        recordStatement(OperationsType.DEPOSIT, amount, balance);
    }

    public void withdrawal(Amount amount) {
        this.balance = this.balance.subtract(amount);
        recordStatement(OperationsType.WITHDRAWAL, amount, balance);

    }

    private void recordStatement(OperationsType type, Amount amount, Amount balance) {
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
