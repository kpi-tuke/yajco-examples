package yajco.robot.karel.model.condition.obstacle;

import yajco.annotation.Before;
import yajco.robot.karel.runtime.World;

public class BackIsClear extends Obstacle {
    @Before("BACK-IS-CLEAR")
    public BackIsClear() {
        super(false, World.BACK);
    }
}
