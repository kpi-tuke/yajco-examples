package yajco.robot.karel.model.instruction;

import yajco.annotation.Before;
import yajco.robot.karel.model.Instruction;
import yajco.robot.karel.runtime.World;


public class Move extends Instruction {

    @Before("MOVE")
    public Move() {
    }

    @Override
    public void execute(World world) {
        printInfo(world);
        
        world.getKarel().move();
    }
}
