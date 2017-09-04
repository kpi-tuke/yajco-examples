package yajco.robot.karel.model.condition.facing;

import yajco.annotation.Before;
import static yajco.robot.karel.runtime.Direction.WEST;

public class FacingWest extends Facing {
    @Before("FACING-WEST")
    public FacingWest() {
        super(WEST);
    }
}
