package BankAccount;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HistoryTest {

    @Test
    void should_return_an_empty_history_of_past_operations() {
        BankAccount john = new BankAccount();

        assertEquals(List.of(), john.history());
    }

    @Test
    void should_return_an_history_of_an_account_initialized_with_an_amount_of_ten() {
        Amount ten = new Amount(10);
        BankAccount john = new BankAccount(ten);

        assertEquals(List.of("DEPOSIT, 08/02/2022, 10, 10"), john.history());
    }

    @Test
    void should_return_an_history_of_an_account_with_one_transaction() {
        Amount twenty = new Amount(20);
        BankAccount henry = new BankAccount();

        henry.deposit(twenty);

        assertEquals(List.of("DEPOSIT, 08/02/2022, 20, 20"), henry.history());
    }

}
