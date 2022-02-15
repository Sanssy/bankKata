package BankAccount;

import java.time.LocalDate;

public record Transaction(OperationsType operation, LocalDate date, Amount amount) {

    public String consult() {
        return operation +
                ", " +
                date +
                ", " +
                amount.value();
    }

}
