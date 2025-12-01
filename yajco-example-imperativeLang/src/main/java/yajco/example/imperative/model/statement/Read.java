package yajco.example.imperative.model.statement;

import yajco.annotation.After;
import yajco.annotation.Before;
import yajco.example.imperative.machine.Machine;

public class Read implements Statement {
    private final String identifier;
    
    public Read(@Before("READ") @After("SEMICOLON") String identifier) {
        this.identifier = identifier;
    }
    
    @Override
    public void execute() {
        Machine.getInstance().read(getIdentifier());
    }

    /**
     * @return the ident
     */
    public String getIdentifier() {
        return identifier;
    }
}
