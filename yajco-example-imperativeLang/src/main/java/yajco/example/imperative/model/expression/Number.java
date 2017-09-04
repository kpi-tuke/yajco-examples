package yajco.example.imperative.model.expression;

public final class Number implements Expression {
    private final int value;

    public Number(int value) {
        this.value = value;
    }

    public long eval() {
        return getValue();
    }

    /**
     * @return the value
     */
    public long getValue() {
        return value;
    }
}
