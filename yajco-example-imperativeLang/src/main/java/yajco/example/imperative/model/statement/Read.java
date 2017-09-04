package yajco.example.imperative.model.statement;

import yajco.annotation.After;
import yajco.annotation.Before;
import yajco.example.imperative.machine.Machine;

public class Read implements Statement {
    private final String ident;
    
    public Read(@Before("READ") @After("SEMICOLON") String ident) {
        this.ident = ident;
    }
    
    @Override
    public void execute() {
        Machine.getInstance().read(getIdent());
    }

    /**
     * @return the ident
     */
    public String getIdent() {
        return ident;
    }
}
