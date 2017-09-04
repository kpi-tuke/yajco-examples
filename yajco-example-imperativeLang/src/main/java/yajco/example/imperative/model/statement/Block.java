package yajco.example.imperative.model.statement;

import yajco.annotation.After;
import yajco.annotation.Before;
import yajco.annotation.Separator;

public class Block implements Statement {
    private final Statement[] statements;

    @Before("LBR") @After("RBR")
    public Block(Statement[] statements) {
        this.statements = statements;
    }

    public void execute() {
        for (Statement statement : getStatements()) {
            statement.execute();
        }
    }

    /**
     * @return the statements
     */
    public Statement[] getStatements() {
        return statements;
    }
}
