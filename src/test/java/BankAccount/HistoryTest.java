package BankAccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.DateProvider;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HistoryTest {
    LocalDate dateProvider;

    @BeforeEach
    void dateMocked() {
        dateProvider = DateProvider.today();
    }

    @Test
    void should_return_an_empty_history_of_past_operations() {
        BankAccount john = new BankAccount();

        assertEquals(List.of(), john.history());
    }

    @Test
    void should_return_an_history_of_an_account_initialized_with_an_amount_of_ten() {
        Amount ten = new Amount(10);
        BankAccount john = new BankAccount(ten, dateProvider);
        Transaction transaction = new Transaction(OperationsType.DEPOSIT, dateProvider, ten);


        assertEquals(List.of(transaction), john.history());
    }

    @Test
    void should_return_an_history_of_an_account_with_one_transaction() {
        Amount twenty = new Amount(20);
        BankAccount henry = new BankAccount();
        Transaction transaction = new Transaction(OperationsType.DEPOSIT, dateProvider, twenty);

        henry.deposit(twenty, dateProvider);

        assertEquals(List.of(transaction), henry.history());
    }

    @Test
    void should_return_an_history_of_an_account_with_two_same_transaction_type() {
        Amount twenty = new Amount(20);
        Amount fifty = new Amount(50);
        BankAccount max = new BankAccount();
        Transaction transactionOne = new Transaction(OperationsType.DEPOSIT, dateProvider, twenty);
        Transaction transactionTwo = new Transaction(OperationsType.DEPOSIT, dateProvider, fifty);

        max.deposit(twenty, dateProvider);
        max.deposit(fifty, dateProvider);

        assertEquals(List.of(transactionOne, transactionTwo), max.history());
    }

    @Test
    void should_return_an_history_of_an_account_with_different_transaction_type() {
        Amount twenty = new Amount(20);
        Amount fifty = new Amount(50);
        BankAccount marco = new BankAccount();

        Transaction transactionOne = new Transaction(OperationsType.DEPOSIT, dateProvider, fifty);
        Transaction transactionTwo = new Transaction(OperationsType.WITHDRAWAL, dateProvider, twenty);

        marco.deposit(fifty, dateProvider);
        marco.withdrawal(twenty, dateProvider);

        assertEquals(List.of(transactionOne,transactionTwo), marco.history());
    }

    @Test
    void should_return_an_history_of_an_account_with_several_transactions() {
        Amount twenty = new Amount(20);
        Amount ten = new Amount(10);
        Amount fifty = new Amount(50);
        Amount hundred = new Amount(100);
        BankAccount marco = new BankAccount();

        marco.deposit(fifty, dateProvider);
        marco.deposit(hundred, dateProvider);
        marco.withdrawal(ten, dateProvider);
        marco.withdrawal(twenty, dateProvider);
        marco.deposit(hundred, dateProvider);
        marco.withdrawal(fifty, dateProvider);
        marco.withdrawal(ten, dateProvider);

        Transaction transactionOne = new Transaction(OperationsType.DEPOSIT, dateProvider, fifty);
        Transaction transactionTwo = new Transaction(OperationsType.DEPOSIT, dateProvider, hundred);
        Transaction transactionThree = new Transaction(OperationsType.WITHDRAWAL, dateProvider, ten);
        Transaction transactionFour = new Transaction(OperationsType.WITHDRAWAL, dateProvider, twenty);
        Transaction transactionFive = new Transaction(OperationsType.DEPOSIT, dateProvider, hundred);
        Transaction transactionSix = new Transaction(OperationsType.WITHDRAWAL, dateProvider, fifty);
        Transaction transactionSeven = new Transaction(OperationsType.WITHDRAWAL, dateProvider, ten);

        assertEquals(List.of(
                transactionOne,
                transactionTwo,
                transactionThree,
                transactionFour,
                transactionFive,
                transactionSix,
                transactionSeven
        ), marco.history());
    }
}
