package yajco.example.desk.model;

public abstract class Factor extends Expression {
    public abstract int getValue();

    @Override
    public String code() {
        return "PUSH " + getValue() + "\n";
    }
}
