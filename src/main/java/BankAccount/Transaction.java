package BankAccount;

import utils.DateConverter;

import java.text.ParseException;
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
        if (operationsType.equals(OperationsType.DEPOSIT))
            return balance = balance.add(amount);
        return balance = balance.subtract(amount);
    }

    public String details() {
        return operationsType +
                ", " +
                DateConverter.formatDate(date) +
                ", " +
                amount.value() +
                ", " +
                balance.value();
    }
}
