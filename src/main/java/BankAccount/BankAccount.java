package BankAccount;

import java.util.Date;
import java.util.List;

public class BankAccount {

    private Amount balance = new Amount(0);
    private final Statement statement = new Statement();

    public BankAccount() {
    }

    public BankAccount(Amount amount) {
        deposit(amount);
    }

    public Amount getBalance() {
        return this.balance;
    }

    public void deposit(Amount amount) {
        recordStatement(OperationsType.DEPOSIT, amount, this.balance);
    }

    public void withdrawal(Amount amount) {
        recordStatement(OperationsType.WITHDRAWAL, amount, this.balance);
    }

    private void recordStatement(OperationsType type, Amount amount, Amount balance) {
        Transaction transaction = new Transaction(type, new Date(), amount, balance);

        this.balance = transaction.updateBalance();

        this.statement.addTransaction(transaction);
    }

    public List<String> history() {
        return this.statement.consult();
    }

}
