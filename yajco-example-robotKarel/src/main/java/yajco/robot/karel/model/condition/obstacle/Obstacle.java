package yajco.robot.karel.model.condition.obstacle;

import yajco.robot.karel.runtime.World;
import yajco.robot.karel.model.Condition;

public abstract class Obstacle extends Condition {
    private final boolean blocked;

    private final int side;

    public Obstacle(boolean blocked, int side) {
        this.blocked = blocked;
        this.side = side;
    }

    @Override
    public boolean eval(World world) {
        int angle = (world.getKarel().getFacing().getAngle() + side) % 360;
        boolean result = world.isObstacleOn(world.angleToOffsetX(angle), world.angleToOffsetY(angle));

        return blocked ? result : !result;
    }
}
