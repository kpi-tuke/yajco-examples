package yajco.robot.karel.model.condition.obstacle;

import yajco.annotation.Before;
import yajco.robot.karel.runtime.World;

public class BackIsBlocked extends Obstacle {
    @Before("BACK-IS-BLOCKED")
    public BackIsBlocked() {
        super(true, World.BACK);
    }
}
