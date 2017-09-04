package yajco.robot.karel.model.condition.obstacle;

import yajco.annotation.Before;
import yajco.robot.karel.runtime.World;

public class LeftIsBlocked extends Obstacle {
    @Before("LEFT-IS-BLOCKED")
    public LeftIsBlocked() {
        super(true, World.LEFT);
    }
}
