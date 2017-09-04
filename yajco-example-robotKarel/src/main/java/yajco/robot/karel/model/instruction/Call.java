package yajco.robot.karel.model.instruction;

import yajco.annotation.reference.References;
import yajco.robot.karel.model.Definition;
import yajco.robot.karel.model.Instruction;
import yajco.robot.karel.runtime.World;

public class Call extends Instruction {
    private Definition definition;
    
    public Call(@References(Definition.class) String ident) {
    }

    @Override
    public void execute(World world) {
        definition.execute(world);
    }
}
