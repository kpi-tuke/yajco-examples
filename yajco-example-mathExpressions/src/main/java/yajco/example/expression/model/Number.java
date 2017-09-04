package yajco.example.expression.model;

import java.util.List;

//TODO: Co ak by boli rozne formy zapisu cisla - hexa, octal, binary?
//TODO: Ak je iba jedna premenna (resp. vola sa value) mohlo by to odvodit podla triedy
public final class Number extends Expression {
    private final int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
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
