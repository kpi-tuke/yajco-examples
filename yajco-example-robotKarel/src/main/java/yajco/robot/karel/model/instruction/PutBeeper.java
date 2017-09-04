package yajco.robot.karel.model.instruction;

import yajco.annotation.Before;
import yajco.robot.karel.runtime.ExecutionException;
import yajco.robot.karel.runtime.Robot;
import yajco.robot.karel.runtime.World;
import yajco.robot.karel.model.Instruction;

public class PutBeeper extends Instruction {
    @Before("PUTBEEPER")
    public PutBeeper() {
    }

    @Override
    public void execute(World world) {
        printInfo(world);
        
        Robot karel = world.getKarel();
        if (karel.getBeepers() > 0) {
            world.putBeeperOn(karel.getPosX(), karel.getPosY());
            karel.setBeepers(karel.getBeepers() - 1);
        } else {
            throw new ExecutionException("Put beeper operation failed! There is no beeper in Karel's bag.");
        }
    }
}
