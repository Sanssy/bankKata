package BankAccount;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StatementTest {

    @Test
    void should_add_a_transaction_to_the_statement() throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse("07/02/2022");
        Amount depositAmount = new Amount(200);
        Amount balanceAmount = new Amount(1000);
        Transaction transaction = new Transaction(OperationsType.DEPOSIT, date, depositAmount, balanceAmount);
        Statement statement = new Statement();

        statement.addTransaction(transaction);

        assertEquals(List.of(transaction.details()), statement.consult());
    }

}
