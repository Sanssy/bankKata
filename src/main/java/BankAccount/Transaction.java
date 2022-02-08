package BankAccount;

import utils.DateConverter;

import java.util.Date;

public class Transaction {

    private Amount balance;
    private final Amount amount;
    private final OperationsType operationsType;
    private final Date date;

    public Transaction(OperationsType operation, Date date, Amount amount, Amount balance) {
        this.operationsType = operation;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public Amount updateBalance() {
        if (this.operationsType.equals(OperationsType.DEPOSIT))
            return this.balance = this.balance.add(this.amount);
        return this.balance = this.balance.subtract(this.amount);
    }

    public String details() {
        return this.operationsType+
                ", " +
                DateConverter.formatDate(this.date) +
                ", " +
                this.amount.value() +
                ", " +
                this.balance.value();
    }
}
