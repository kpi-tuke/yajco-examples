package yajco.example.extMathExpr.model;

//TODO: Co ak by boli rozne formy zapisu cisla - hexa, octal, binary?
//konverzia - resp. si dam String konstruktor?
//TODO: Ak je iba jedna premenna (resp. vola sa value) mohlo by to odvodit podla triedy
public final class Number extends Expression {
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
    public int getValue() {
        return value;
    }
}
