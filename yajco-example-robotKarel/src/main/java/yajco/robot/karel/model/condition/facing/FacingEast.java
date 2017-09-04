package yajco.robot.karel.model.condition.facing;

import yajco.annotation.Before;
import static yajco.robot.karel.runtime.Direction.EAST;

public class FacingEast extends Facing {
    @Before("FACING-EAST")
    public FacingEast() {
        super(EAST);
    }
}
