package yajco.example.imperative.machine;

public class ReturnException extends RuntimeException {
    private final long value;

    public ReturnException(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }    
}
