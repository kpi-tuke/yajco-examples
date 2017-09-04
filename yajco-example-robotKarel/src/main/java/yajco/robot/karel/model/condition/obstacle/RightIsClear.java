package yajco.robot.karel.model.condition.obstacle;

import yajco.annotation.Before;
import yajco.robot.karel.runtime.World;

public class RightIsClear extends Obstacle {
    @Before("RIGHT-IS-CLEAR")
    public RightIsClear() {
        super(false, World.RIGHT);
    }
}
