package yajco.example.extMathExpr.model;

// TODO: What if there were different number formats – hexadecimal, octal, binary?
// Conversion – or should I provide a String constructor instead?
// TODO: If there is only one variable (or it's named "value"), it could be inferred from the class.
public final class Number extends Expression {
    private final int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public long eval() {
        return getValue();
    }

    public int getValue() {
        return value;
    }
}
