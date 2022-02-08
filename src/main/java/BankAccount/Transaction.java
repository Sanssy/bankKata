package BankAccount;

import java.util.Date;

public class Transaction {

    private final Amount balance;
    private final Amount amount;
    private final OperationsType operationsType;
    private Date date;

    public Transaction(OperationsType operation, Date date, Amount amount, Amount balance) {
        this.operationsType = operation;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public Amount updateBalance() {
        if (operationsType.equals(OperationsType.DEPOSIT))
            return balance.add(amount);
        return balance.subtract(amount);
    }
}
