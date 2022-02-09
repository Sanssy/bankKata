package BankAccount;

import java.util.Date;
import java.util.List;

public class BankAccount {

    private Amount balance = new Amount(0);
    private final Statement statement = new Statement();
    private Transaction transaction;

    public BankAccount() {
    }

    public BankAccount(Amount amount) {
        this.balance = amount;
    }

    public BankAccount(Amount amount, Date date) {
        this.deposit(amount, date);
    }

    public Amount getBalance() {
        return this.balance;
    }

    public void deposit(Amount amount, Date date) {
        recordStatement(OperationsType.DEPOSIT, date, amount);
    }

    public void withdrawal(Amount amount, Date date) {
        recordStatement(OperationsType.WITHDRAWAL, date, amount);
    }

    private void recordStatement(OperationsType type, Date date, Amount amount) {
        this.transaction = new Transaction(type, date, amount, balance);

        this.balance = this.transaction.updateBalance();

        this.statement.addTransaction(this.transaction);
    }

    public List<String> history() {
        return this.statement.consult();
    }

}
