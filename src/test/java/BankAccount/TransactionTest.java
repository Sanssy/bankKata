package BankAccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.DateProvider;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTest {
    LocalDate dateProvider;

    @BeforeEach
    void dateMocked() {
        dateProvider = DateProvider.today();
    }

    @Test
    void should_print_the_transaction() {
        Amount withdrawalAmount = new Amount(100);
        OperationsType deposit = OperationsType.DEPOSIT;

        Transaction transaction = new Transaction(deposit, dateProvider, withdrawalAmount);

        assertEquals("DEPOSIT, "+ dateProvider + ", 100", transaction.consult());
    }

}
