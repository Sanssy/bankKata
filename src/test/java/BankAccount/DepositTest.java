package BankAccount;

import org.junit.jupiter.api.Test;
import utils.DateConverter;

import java.text.ParseException;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class DepositTest {

    @Test
    void should_return_a_balance_of_zero() {
        BankAccount patrick = new BankAccount();

        Amount zero = new Amount(0);

        assertThat(zero).isEqualTo(patrick.getBalance());
    }

    @Test
    void should_return_a_balance_of_one_after_deposit_of_one() throws ParseException {
        BankAccount patrick = new BankAccount();
        Amount one = new Amount(1);
        Date date = DateConverter.convertToDate("08/02/2022");

        patrick.deposit(one, date);

        assertThat(one).isEqualTo(patrick.getBalance());
    }

    @Test
    void should_return_a_balance_of_two_after_two_deposits_of_one() throws ParseException {
        BankAccount Eddy = new BankAccount();

        Amount one = new Amount(1);
        Amount two = new Amount(2);
        Date date = DateConverter.convertToDate("08/02/2022");

        Eddy.deposit(one, date);
        Eddy.deposit(one, date);

        assertThat(two).isEqualTo(Eddy.getBalance());
    }

    @Test
    void should_return_a_balance_of_ten_after_an_initialization_of_ten() {
        Amount ten = new Amount(10);
        BankAccount Eddy = new BankAccount(ten);

        assertThat(ten).isEqualTo(Eddy.getBalance());
    }

    @Test
    void should_return_a_balance_of_ten_after_two_deposits_of_one_and_an_account_initialization_of_eight() throws ParseException {
        Amount eight = new Amount(8);
        BankAccount Eddy = new BankAccount(eight);
        Amount one = new Amount(1);
        Amount ten = new Amount(10);
        Date date = DateConverter.convertToDate("08/02/2022");

        Eddy.deposit(one, date);
        Eddy.deposit(one, date);

        assertThat(ten).isEqualTo(Eddy.getBalance());
    }
}

