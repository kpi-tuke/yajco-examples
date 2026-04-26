package yajco.robot.karel.model.condition.beeper;

import yajco.annotation.Before;
import yajco.robot.karel.model.Condition;
import yajco.robot.karel.runtime.Robot;
import yajco.robot.karel.runtime.World;

public class NextToABeeper extends Condition {
    @Before("NEXT-TO-A-BEEPER")
    public NextToABeeper() {
    }

    public boolean eval(World world) {
        Robot karel = world.getKarel();
        return world.isBeeperOn(karel.getPosX(), karel.getPosY());
    }
}
