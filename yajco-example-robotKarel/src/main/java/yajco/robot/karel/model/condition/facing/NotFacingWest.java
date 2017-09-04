package yajco.robot.karel.model.condition.facing;

import yajco.annotation.Before;
import static yajco.robot.karel.runtime.Direction.WEST;

public class NotFacingWest extends Facing {
    @Before("NOT-FACING-WEST")
    public NotFacingWest() {
        super(true, WEST);
    }
}
