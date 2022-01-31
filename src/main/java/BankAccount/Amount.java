package BankAccount;

public record Amount(int value) {

    public Amount add(Amount amount) {
        return new Amount(this.value + amount.value);
    }

    public Amount subtract(Amount amount) {
        return new Amount(this.value - amount.value);
    }
}
