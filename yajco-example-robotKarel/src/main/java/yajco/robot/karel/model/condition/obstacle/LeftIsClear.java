package yajco.robot.karel.model.condition.obstacle;

import yajco.annotation.Before;
import yajco.robot.karel.runtime.World;

public class LeftIsClear extends Obstacle {
    @Before("LEFT-IS-CLEAR")
    public LeftIsClear() {
        super(false, World.LEFT);
    }
}
