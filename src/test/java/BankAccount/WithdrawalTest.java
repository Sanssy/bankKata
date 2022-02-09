package BankAccount;

import org.junit.jupiter.api.Test;
import utils.DateConverter;

import java.text.ParseException;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class WithdrawalTest {

    @Test
    void should_return_a_balance_of_zero_after_a_withdrawal_of_one_on_a_balance_of_one() throws ParseException {
        Amount one = new Amount(1);
        Amount zero = new Amount(0);
        BankAccount tony = new BankAccount(one);
        Date date = DateConverter.convertToDate("08/02/2022");

        tony.withdrawal(one, date);

        assertThat(zero).isEqualTo(tony.getBalance());
    }

    @Test
    void should_return_a_balance_of_two_after_a_withdrawal_of_one_on_a_balance_of_three() throws ParseException {
        Amount one = new Amount(1);
        Amount two = new Amount(2);
        Amount three = new Amount(3);
        BankAccount tony = new BankAccount(three);
        Date date = DateConverter.convertToDate("08/02/2022");

        tony.withdrawal(one, date);

        assertThat(two).isEqualTo(tony.getBalance());
    }

    @Test
    void should_return_balance_of_zero_while_trying_withdrawal_amount_on_a_balance_of_zero() throws ParseException {
        Amount ten = new Amount(10);
        Amount zero = new Amount(0);
        BankAccount bob = new BankAccount();
        Date date = DateConverter.convertToDate("08/02/2022");

        bob.withdrawal(ten, date);

        assertThat(zero).isEqualTo(bob.getBalance());
    }

    @Test
    void should_return_same_balance_while_trying_withdrawal_amount_greater_than_the_balance() throws ParseException {
        Amount fifteen = new Amount(15);
        Amount twenty = new Amount(20);
        Date date = DateConverter.convertToDate("08/02/2022");
        BankAccount tony = new BankAccount(fifteen);

        tony.withdrawal(twenty, date);

        assertThat(fifteen).isEqualTo(tony.getBalance());
    }

}
