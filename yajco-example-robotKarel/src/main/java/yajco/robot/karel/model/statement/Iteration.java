package yajco.robot.karel.model.statement;

import yajco.annotation.Before;
import yajco.robot.karel.model.Statement;
import yajco.robot.karel.runtime.World;


public class Iteration extends Statement {
    private final int value;

    private final Statement statement;

    @Before("ITERATE")
    public Iteration(
            int value,
            @Before("TIMES") Statement statement) {
        this.value = value;
        this.statement = statement;
    }

    @Override
    public void execute(World world) {
        for(int i = 0; i < value; i++) {
            statement.execute(world);
        }
    }
}
