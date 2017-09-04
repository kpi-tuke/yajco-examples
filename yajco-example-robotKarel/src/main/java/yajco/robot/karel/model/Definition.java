package yajco.robot.karel.model;

import yajco.annotation.Before;
import yajco.annotation.Range;
import yajco.annotation.reference.Identifier;
import yajco.robot.karel.runtime.World;

public class Definition {
    @Identifier
    private final String ident;

    private final Statement[] statements;

    @Before("DEFINE")
    public Definition(
            String ident,
            @Before("AS")
            @Range(minOccurs = 1) Statement[] statements) {
        this.ident = ident;
        this.statements = statements;
    }

    public void execute(World world) {
        for (Statement statement : statements) {
            statement.execute(world);
        }
    }
}
