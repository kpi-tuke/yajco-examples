package yajco.robot.karel.model.condition.facing;

import yajco.annotation.Before;
import static yajco.robot.karel.runtime.Direction.EAST;

public class NotFacingEast extends Facing {
    @Before("NOT-FACING-EAST")
    public NotFacingEast() {
        super(true, EAST);
    }
}
