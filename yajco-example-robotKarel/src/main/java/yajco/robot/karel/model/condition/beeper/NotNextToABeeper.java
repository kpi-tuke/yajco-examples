package yajco.robot.karel.model.condition.beeper;

import yajco.annotation.Before;
import yajco.robot.karel.model.Condition;
import yajco.robot.karel.runtime.World;

public class NotNextToABeeper extends Condition {
    @Before("NOT-NEXT-TO-A-BEEPER")
    public NotNextToABeeper() {
    }

    public boolean eval(World world) {       
        return !new NextToABeeper().eval(world);
    }
}
