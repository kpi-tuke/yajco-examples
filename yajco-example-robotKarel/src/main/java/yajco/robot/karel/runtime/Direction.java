package yajco.robot.karel.runtime;

public enum Direction {

    NORTH(0), EAST(90), SOUTH(180), WEST(270);
    
    private int angle;

    private Direction(int angle) {
        this.angle = angle;
    }

    public int getAngle() {
        return angle;
    }
    
}
