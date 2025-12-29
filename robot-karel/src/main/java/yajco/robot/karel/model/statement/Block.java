package yajco.robot.karel.model.statement;

import yajco.annotation.After;
import yajco.annotation.Before;
import yajco.robot.karel.runtime.World;
import yajco.robot.karel.model.Statement;

public class Block extends Statement {
    private final Statement[] statements;

    @Before("BEGIN")
    @After("END")
    public Block(Statement[] statements) {
        this.statements = statements;
    }

    @Override
    public void execute(World world) {
        for (Statement statement : statements) {
            statement.execute(world);
        }
    }
}
