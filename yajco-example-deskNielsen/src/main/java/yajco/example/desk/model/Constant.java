package yajco.example.desk.model;

import yajco.annotation.Before;
import yajco.annotation.reference.Identifier;

public class Constant {
    @Identifier
    private final String name;

    private final Number number;

    public Constant(String name, @Before("=") Number number) {
        this.name = name;
        this.number = number;
    }

    public int getValue() {
        return getNumber().getValue();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the number
     */
    public Number getNumber() {
        return number;
    }

}
