package BankAccount;

import org.junit.jupiter.api.Test;
import utils.DateConverter;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HistoryTest {

    @Test
    void should_return_an_empty_history_of_past_operations() {
        BankAccount john = new BankAccount();

        assertEquals(List.of(), john.history());
    }

    @Test
    void should_return_an_history_of_an_account_initialized_with_an_amount_of_ten() throws ParseException {
        Amount ten = new Amount(10);
        Date date = DateConverter.convertToDate("08/02/2022");
        BankAccount john = new BankAccount(ten, date);

        assertEquals(List.of("DEPOSIT, 08/02/2022, 10, 10"), john.history());
    }

    @Test
    void should_return_an_history_of_an_account_with_one_transaction() throws ParseException {
        Amount twenty = new Amount(20);
        Date date = DateConverter.convertToDate("08/02/2022");
        BankAccount henry = new BankAccount();


        henry.deposit(twenty, date);

        assertEquals(List.of("DEPOSIT, 08/02/2022, 20, 20"), henry.history());
    }

    @Test
    void should_return_an_history_of_an_account_with_two_same_transaction_type() throws ParseException {
        Amount twenty = new Amount(20);
        Amount fifty = new Amount(50);
        BankAccount max = new BankAccount();

        Date date = DateConverter.convertToDate("09/02/2022");
        max.deposit(twenty, date);
        max.deposit(fifty, date);

        assertEquals(List.of("DEPOSIT, 09/02/2022, 20, 20", "DEPOSIT, 09/02/2022, 50, 70"), max.history());
    }

    @Test
    void should_return_an_history_of_an_account_with_different_transaction_type() throws ParseException {
        Amount twenty = new Amount(20);
        Amount fifty = new Amount(50);
        BankAccount marco = new BankAccount();

        Date date = DateConverter.convertToDate("08/02/2022");
        marco.deposit(fifty, date);
        marco.withdrawal(twenty, date);

        assertEquals(List.of("DEPOSIT, 08/02/2022, 50, 50", "WITHDRAWAL, 08/02/2022, 20, 30"), marco.history());
    }

    @Test
    void should_return_an_history_of_an_account_with_several_transactions() throws ParseException {
        Amount twenty = new Amount(20);
        Amount ten = new Amount(10);
        Amount fifty = new Amount(50);
        Amount hundred = new Amount(100);
        BankAccount marco = new BankAccount();

        Date date = DateConverter.convertToDate("08/02/2022");
        marco.deposit(fifty, date);
        marco.deposit(hundred, date);
        marco.withdrawal(ten, date);
        marco.withdrawal(twenty, date);
        marco.deposit(hundred, date);
        marco.withdrawal(fifty, date);
        marco.withdrawal(ten, date);

        assertEquals(List.of(
                "DEPOSIT, 08/02/2022, 50, 50",
                "DEPOSIT, 08/02/2022, 100, 150",
                "WITHDRAWAL, 08/02/2022, 10, 140",
                "WITHDRAWAL, 08/02/2022, 20, 120",
                "DEPOSIT, 08/02/2022, 100, 220",
                "WITHDRAWAL, 08/02/2022, 50, 170",
                "WITHDRAWAL, 08/02/2022, 10, 160"
        ), marco.history());
    }
}
