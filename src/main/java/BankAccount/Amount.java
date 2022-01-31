package BankAccount;

public record Amount(int value) {

    public Amount add(Amount amount) {
        return new Amount(this.value + amount.value);
    }

    public Amount subtract(Amount amount) {
        if (isGreaterOrEqualsTo(amount))
            return this.add(amount.opposite());
        return this.add(initAmountToZero());
    }

    private Amount initAmountToZero() {
        return new Amount(0);
    }

    private boolean isGreaterOrEqualsTo(Amount amount) {
        return this.value >= amount.value;
    }

    public Amount opposite() {
        return new Amount(- this.value);
    }
}
