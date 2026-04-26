package yajco.example.desk.model;

public final class Number extends Factor {
    private final int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }
}
