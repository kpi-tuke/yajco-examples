package yajco.robot.karel.model.statement;

import yajco.annotation.Before;
import yajco.robot.karel.runtime.World;
import yajco.robot.karel.model.Condition;
import yajco.robot.karel.model.Statement;

public class Loop extends Statement {
    private final Condition condition;

    private final Statement statement;

    @Before("WHILE")
    public Loop(
            Condition condition,
            @Before("DO") Statement statement) {
        this.condition = condition;
        this.statement = statement;
    }

    @Override
    public void execute(World world) {
        //Ako je mozne zapisat v AG
        //- podmieneny cyklus (vid dole)
        //- cyklus s definovanym poctom iteracii
        while (condition.eval(world)) {
            statement.execute(world);
        }
    }
}
