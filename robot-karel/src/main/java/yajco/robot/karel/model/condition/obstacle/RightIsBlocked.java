package yajco.robot.karel.model.condition.obstacle;

import yajco.annotation.Before;
import yajco.robot.karel.runtime.World;

public class RightIsBlocked extends Obstacle {
    @Before("RIGHT-IS-BLOCKED")
    public RightIsBlocked() {
        super(true, World.RIGHT);
    }
}
