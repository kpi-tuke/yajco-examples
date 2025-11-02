package yajco.robot.karel.runtime;

public enum Direction {

    NORTH(0), EAST(90), SOUTH(180), WEST(270);

    private final int angle;

    Direction(int angle) {
        this.angle = angle;
    }

    public int getAngle() {
        return angle;
    }

}
