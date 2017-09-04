package yajco.robot.karel.model.condition.facing;

import yajco.annotation.Before;
import static yajco.robot.karel.runtime.Direction.SOUTH;

public class NotFacingSouth extends Facing {
    @Before("NOT-FACING-SOUTH")
    public NotFacingSouth() {
        super(true, SOUTH);
    }
}
