package yajco.example.imperative.model.function;

import yajco.annotation.reference.Identifier;

public class Parameter {
    @Identifier(unique = "../yajco.example.imperative.model.function.Parameter")
    private final String name;

    public Parameter(String identifier) {
        this.name = identifier;
    }

    public String getName() {
        return name;
    }

    public String getIdentifier() {
        return name;
    }
}
