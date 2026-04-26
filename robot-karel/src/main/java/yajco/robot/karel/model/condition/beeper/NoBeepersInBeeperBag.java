package yajco.robot.karel.model.condition.beeper;

import yajco.annotation.Before;
import yajco.robot.karel.model.Condition;
import yajco.robot.karel.runtime.World;

public class NoBeepersInBeeperBag extends Condition {
    @Before("NO-BEEPERS-IN-BEEPER-BAG")
    public NoBeepersInBeeperBag() {
    }

    public boolean eval(World world) {
        return world.getKarel().getBeepers() == 0;
    }
}
