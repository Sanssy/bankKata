package BankAccount;

import utils.DateProvider;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private final Amount balance = new Amount(0);
    private final List<Transaction> statement = new ArrayList<>();

    public BankAccount() {
    }

    public BankAccount(Amount amount) {
        LocalDate today = DateProvider.today();
        this.deposit(amount, today);
    }

    public BankAccount(Amount amount, LocalDate date) {
        this.deposit(amount, date);
    }

    public Amount balance() {
        return this.statement.stream()
                .map(transaction -> transaction.amount())
                .reduce(Amount::add)
                .orElse(balance);
    }

    public void deposit(Amount amount, LocalDate date) {
        recordStatement(OperationsType.DEPOSIT, date, amount);
    }

    public void withdrawal(Amount amount, LocalDate date) {
        recordStatement(OperationsType.WITHDRAWAL, date, amount.opposite());
    }

    private void recordStatement(OperationsType type, LocalDate date, Amount amount) {
        this.statement.add(new Transaction(type, date, amount));
    }

    public List<Transaction> history() {
        return this.statement.stream().map(t -> new Transaction(t.operation(), t.date(), t.amount().absolute())).toList();
    }

}
