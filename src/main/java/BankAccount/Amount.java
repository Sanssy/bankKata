package BankAccount;

public record Amount(int value) {

    public Amount add(Amount amount) {
        return new Amount(this.value + amount.value);
    }

    public Amount subtract(Amount amount) {
        if (isGreaterThanOrEqualsTo(amount))
            return this.add(amount.opposite());
        return this.add(amountOfZero());
    }

    public Amount opposite() {
        return new Amount(- this.value);
    }

    private boolean isGreaterThanOrEqualsTo(Amount amount) {
        return this.value >= amount.value;
    }

    private Amount amountOfZero() {
        return new Amount(0);
    }
}
