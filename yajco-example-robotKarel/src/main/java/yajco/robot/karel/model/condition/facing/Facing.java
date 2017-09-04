package yajco.robot.karel.model.condition.facing;

import yajco.robot.karel.model.Condition;
import yajco.robot.karel.runtime.Direction;
import yajco.robot.karel.runtime.World;

public abstract class Facing extends Condition {
    private final boolean negate;

    private final Direction desiredDirection;

    public Facing(Direction desiredDirection) {
        this(false, desiredDirection);
    }

    public Facing(boolean negate, Direction desiredDirection) {
        this.negate = negate;
        this.desiredDirection = desiredDirection;
    }

    public boolean eval(World world) {
        Direction facing = world.getKarel().getFacing();
        return negate ? desiredDirection != facing : desiredDirection == facing;
    }
}
