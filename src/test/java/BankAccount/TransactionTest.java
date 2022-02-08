package BankAccount;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    @Test
    void should_return_a_balance_of_ten_after_the_transaction_happened() throws ParseException {
        Amount ten = new Amount(10);
        Amount zero = new Amount(0);
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse("08/02/2022");
        OperationsType deposit = OperationsType.DEPOSIT;

        Transaction transaction = new Transaction(deposit, date, ten, zero);

        assertEquals(ten, transaction.updateBalance());
    }

    @Test
    void should_print_the_transaction_detail() throws ParseException {
        Amount oneHundred = new Amount(100);
        Amount twoThousand = new Amount(2000);
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse("08/02/2022");
        OperationsType deposit = OperationsType.WITHDRAWAL;

        Transaction transaction = new Transaction(deposit, date, oneHundred, twoThousand);

        transaction.updateBalance();

        assertEquals("WITHDRAWAL, 08/02/2022, 100, 1900", transaction.details());
    }

}
