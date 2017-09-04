package yajco.robot.karel.model.condition.facing;

import yajco.annotation.Before;
import static yajco.robot.karel.runtime.Direction.NORTH;

public class FacingNorth extends Facing {
    @Before("FACING-NORTH")
    public FacingNorth() {
        super(NORTH);
    }
}
