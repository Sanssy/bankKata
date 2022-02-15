package BankAccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.DateProvider;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class DepositTest {
    LocalDate dateProvider;

    @BeforeEach
    void dateMocked() {
        dateProvider = DateProvider.today();
    }

    @Test
    void should_return_a_balance_of_zero() {
        BankAccount patrick = new BankAccount();

        Amount zero = new Amount(0);

        assertThat(zero).isEqualTo(patrick.balance());
    }

    @Test
    void should_return_a_balance_of_one_after_deposit_of_one() {
        BankAccount patrick = new BankAccount();
        Amount one = new Amount(1);

        patrick.deposit(one, dateProvider);

        assertThat(one).isEqualTo(patrick.balance());
    }

    @Test
    void should_return_a_balance_of_two_after_two_deposits_of_one(){
        BankAccount Eddy = new BankAccount();

        Amount one = new Amount(1);
        Amount two = new Amount(2);

        Eddy.deposit(one, dateProvider);
        Eddy.deposit(one, dateProvider);

        assertThat(two).isEqualTo(Eddy.balance());
    }

    @Test
    void should_return_a_balance_of_ten_after_an_initialization_of_ten() {
        Amount ten = new Amount(10);
        BankAccount Eddy = new BankAccount(ten);

        assertThat(ten).isEqualTo(Eddy.balance());
    }

    @Test
    void should_return_a_balance_of_ten_after_two_deposits_of_one_and_an_account_initialization_of_eight() {
        Amount eight = new Amount(8);
        BankAccount Eddy = new BankAccount(eight);
        Amount one = new Amount(1);
        Amount ten = new Amount(10);

        Eddy.deposit(one, dateProvider);
        Eddy.deposit(one, dateProvider);

        assertThat(ten).isEqualTo(Eddy.balance());
    }
}

