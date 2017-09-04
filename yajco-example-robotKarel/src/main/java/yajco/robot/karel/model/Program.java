package yajco.robot.karel.model;

import yajco.annotation.After;
import yajco.annotation.Before;
import yajco.annotation.Range;
import yajco.robot.karel.runtime.ExecutionException;
import yajco.robot.karel.runtime.TurnOffException;
import yajco.robot.karel.runtime.World;


public class Program {
    private final Definition[] definitions;

    private final Statement[] statements;

    @Before("BEGINNING-OF-PROGRAM")
    @After("END-OF-PROGRAM")
    public Program(Definition[] definitions,
            @Before("BEGINNING-OF-EXECUTION")
            @After("END-OF-EXECUTION")
            @Range(minOccurs = 1) Statement[] statements) {
        this.definitions = definitions;
        this.statements = statements;
    }

    public void execute(World world) {
        try {
            for (Statement statement : statements) {
                statement.execute(world);
            }
            throw new ExecutionException("Error executing program! The program should end with Turn Off command");
        } catch (TurnOffException e) {
        }
    }
}
