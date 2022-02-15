package BankAccount;

public record Amount(int value) {

    public Amount add(Amount amount) {
        return new Amount(this.value + amount.value);
    }

    public Amount opposite() {
        return new Amount(- this.value);
    }

    public Amount absolute() {
        return new Amount(Math.abs(this.value));
    }
}
