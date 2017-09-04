package yajco.robot.karel.model.condition.facing;

import yajco.annotation.Before;
import static yajco.robot.karel.runtime.Direction.SOUTH;

public class FacingSouth extends Facing {
    @Before("FACING-SOUTH")
    public FacingSouth() {
        super(SOUTH);
    }
}
