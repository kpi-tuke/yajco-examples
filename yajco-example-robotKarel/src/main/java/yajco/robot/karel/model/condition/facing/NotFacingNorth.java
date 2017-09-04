package yajco.robot.karel.model.condition.facing;

import yajco.annotation.Before;
import static yajco.robot.karel.runtime.Direction.NORTH;

public class NotFacingNorth extends Facing {
    @Before("NOT-FACING-NORTH")
    public NotFacingNorth() {
        super(true, NORTH);
    }
}
