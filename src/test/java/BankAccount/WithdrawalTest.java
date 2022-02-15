package BankAccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.DateProvider;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class WithdrawalTest {
    LocalDate dateProvider;

    @BeforeEach
    void dateMocked() {
        dateProvider = DateProvider.today();
    }

    @Test
    void should_return_a_balance_of_zero_after_a_withdrawal_of_one_on_a_balance_of_one() {
        Amount one = new Amount(1);
        Amount zero = new Amount(0);
        BankAccount tony = new BankAccount(one);

        tony.withdrawal(one, dateProvider);

        assertThat(zero).isEqualTo(tony.balance());
    }

    @Test
    void should_return_a_balance_of_two_after_a_withdrawal_of_one_on_a_balance_of_three() {
        Amount one = new Amount(1);
        Amount two = new Amount(2);
        Amount three = new Amount(3);
        BankAccount tony = new BankAccount(three);

        tony.withdrawal(one, dateProvider);

        assertThat(two).isEqualTo(tony.balance());
    }

    @Test
    void should_return_a_negative_balance_after_a_withdrawal_of_ten_on_a_balance_of_zero() {
        Amount ten = new Amount(10);
        Amount oppositeTen = ten.opposite();
        BankAccount bob = new BankAccount();

        bob.withdrawal(ten, dateProvider);

        assertThat(oppositeTen).isEqualTo(bob.balance());
    }

    @Test
    void should_return_a_negative_balance_after_a_withdrawal_of_twenty_on_a_balance_of_fifteen() {
        Amount fifteen = new Amount(15);
        Amount twenty = new Amount(20);
        Amount oppositeFive = new Amount(5).opposite();
        BankAccount tony = new BankAccount(fifteen);

        tony.withdrawal(twenty, dateProvider);

        assertThat(oppositeFive).isEqualTo(tony.balance());
    }

}
