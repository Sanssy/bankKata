package BankAccount;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    @Test
    void should_return_a_transaction() throws ParseException {

        Amount ten = new Amount(10);
        Amount zero = new Amount(0);
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse("08/02/2022");
        OperationsType deposit = OperationsType.DEPOSIT;

        Transaction transaction = new Transaction(deposit, date, ten, zero);

        assertEquals(ten, transaction.updateBalance());
    }

}
