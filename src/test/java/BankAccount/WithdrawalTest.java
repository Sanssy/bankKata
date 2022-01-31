package BankAccount;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WithdrawalTest {

    @Test
    void should_return_a_balance_of_zero_after_a_withdrawal_of_one_on_a_balance_of_one(){
        Amount one = new Amount(1);
        Amount zero = new Amount(0);
        BankAccount tony = new BankAccount(one);

        tony.withdrawal(one);

        assertThat(zero).isEqualTo(tony.getBalance());
    }

    @Test
    void should_return_a_balance_of_two_after_a_withdrawal_of_one_on_a_balance_of_three(){
        Amount one = new Amount(1);
        Amount two = new Amount(2);
        Amount three = new Amount(3);
        BankAccount tony = new BankAccount(three);

        tony.withdrawal(one);

        assertThat(two).isEqualTo(tony.getBalance());
    }
}
