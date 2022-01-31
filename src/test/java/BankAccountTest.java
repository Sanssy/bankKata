import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BankAccountTest {

    @Test
    void should_return_a_balance_of_zero() {
        BankAccount patrick = new BankAccount();

        assertThat(0).isEqualTo(patrick.getBalance());
    }

    @Test
    void should_return_a_balance_of_one_after_deposit_of_one() {
        BankAccount patrick = new BankAccount();

        patrick.deposit(1);

        assertThat(1).isEqualTo(patrick.getBalance());
    }

    @Test
    void should_return_a_balance_of_two_after_two_deposits_of_one() {
        BankAccount Eddy = new BankAccount();

        Eddy.deposit(1);
        Eddy.deposit(1);

        assertThat(2).isEqualTo(Eddy.getBalance());
    }

    @Test
    void should_return_a_balance_of_ten_after_two_deposits_of_one_and_an_account_initialization_of_eight() {
        BankAccount Eddy = new BankAccount(8);

        Eddy.deposit(1);
        Eddy.deposit(1);

        assertThat(10).isEqualTo(Eddy.getBalance());
    }


}

