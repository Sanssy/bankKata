package BankAccount;

import java.util.ArrayList;
import java.util.List;

public class Statement {

    private final List<Transaction> transactions = new ArrayList<>();

    public Statement() {
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public List<String> consult() {
        List<String> result = new ArrayList<>();
        this.transactions.forEach(transaction -> result.add(transaction.details()));
        return result;
    }
}
