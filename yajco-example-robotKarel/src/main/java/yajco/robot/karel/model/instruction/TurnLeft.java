package yajco.robot.karel.model.instruction;

import yajco.annotation.Before;
import yajco.robot.karel.model.Instruction;
import yajco.robot.karel.runtime.World;


public class TurnLeft extends Instruction {
    @Before("TURNLEFT")
    public TurnLeft() {
    }

    @Override
    public void execute(World world) {
        printInfo(world);

        world.getKarel().turnLeft();
    }
}
