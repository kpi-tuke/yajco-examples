package yajco.robot.karel.model.condition.obstacle;

import yajco.annotation.Before;
import yajco.robot.karel.runtime.World;

public class FrontIsClear extends Obstacle {
    @Before("FRONT-IS-CLEAR")
    public FrontIsClear() {
        super(false, World.FRONT);
    }
}
