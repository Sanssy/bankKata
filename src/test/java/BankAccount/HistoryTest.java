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


}
