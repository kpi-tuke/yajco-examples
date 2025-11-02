package yajco.example.imperative.model.expression;

import yajco.example.imperative.machine.Machine;

public final class Variable implements Expression {
    private final String identifier;

    public Variable(String identifier) {
        this.identifier = identifier;
    }

    public long eval() {
        return Machine.getInstance().getValue(identifier);
    }

    public String getIdentifier() {
        return identifier;
    }
}
