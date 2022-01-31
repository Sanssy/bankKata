import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BankAccountTest {

    @Test
    void should_return_a_balance_of_zero() {
        BankAccount patrick = new BankAccount();

        assertThat(0).isEqualTo(patrick.getBalance());
    }
}

