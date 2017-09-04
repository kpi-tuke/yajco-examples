package yajco.robot.karel.model.instruction;

import yajco.annotation.Before;
import yajco.robot.karel.runtime.ExecutionException;
import yajco.robot.karel.runtime.Robot;
import yajco.robot.karel.runtime.World;
import yajco.robot.karel.model.Instruction;

public class PickBeeper extends Instruction {
    @Before("PICKBEEPER")
    public PickBeeper() {
    }

    @Override
    public void execute(World world) {
        printInfo(world);
        
        Robot karel = world.getKarel();
        if (world.isBeeperOn(karel.getPosX(), karel.getPosY())) {
            world.getBeeperFrom(karel.getPosX(), karel.getPosY());
            karel.setBeepers(karel.getBeepers() + 1);
        } else {
            throw new ExecutionException("Pick beeper operation failed! There is no beeper on the current position of Karel.");
        }
    }
}
