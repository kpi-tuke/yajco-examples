package yajco.robot.karel.model.condition.obstacle;

import yajco.annotation.Before;
import yajco.robot.karel.runtime.World;

public class FrontIsBlocked extends Obstacle {
    @Before("FRONT-IS-BLOCKED")
    public FrontIsBlocked() {
        super(true, World.FRONT);
    }
}
