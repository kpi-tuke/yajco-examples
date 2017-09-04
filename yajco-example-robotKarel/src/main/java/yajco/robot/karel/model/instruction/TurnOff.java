package yajco.robot.karel.model.instruction;

import yajco.annotation.Before;
import yajco.robot.karel.runtime.TurnOffException;
import yajco.robot.karel.runtime.World;
import yajco.robot.karel.model.Instruction;

public class TurnOff extends Instruction {
    @Before("TURNOFF")
    public TurnOff() {
    }

    @Override
    public void execute(World world) {
        printInfo(world);
        
        throw new TurnOffException();
    }
}
