package yajco.robot.karel.model.statement;

import yajco.annotation.Before;
import yajco.annotation.Optional;
import yajco.robot.karel.runtime.World;
import yajco.robot.karel.model.Condition;
import yajco.robot.karel.model.Statement;

public class Conditional extends Statement {
    private final Condition condition;

    private final Statement statement;

    private final Statement elseStatement;

    @Before("IF")
    public Conditional(
            Condition condition,
            @Before("THEN") Statement statement,
            @Optional @Before("ELSE") Statement elseStatement) {
        this.condition = condition;
        this.statement = statement;
        this.elseStatement = elseStatement;
    }

    @Override
    public void execute(World world) {
        if (condition.eval(world)) {
            statement.execute(world);
        } else if (elseStatement != null) {
            elseStatement.execute(world);
        }
    }
}
