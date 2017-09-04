package yajco.robot.karel.runtime;

/**
 * This class represents robot in the world. A robot is defined by its position
 * (x- and y-coordinate) in the world, the angle it is facing and the numbers of
 * beepers in its bag.
 *
 * @author jaro
 */
public class Robot {

    /**
     * X-coordinate of the robot's position in the world.
     */
    private int posX;

    /**
     * Y-coordinate of the robot's position in the world.
     */
    private int posY;

    /**
     * The number of beepers in the robot's bag.
     */
    private int beepers;

    private Direction facing = Direction.NORTH;

    public Direction getFacing() {
        return facing;
    }

    /**
     * Returns the number of beepers in the robot's bag
     *
     * @return number of beepers in the robot's bag
     */
    public int getBeepers() {
        return beepers;
    }

    /**
     * Sets the number of beepers in the robot's bag.
     *
     * @param beepers number of beepers in the robot's bag
     */
    public void setBeepers(int beepers) {
        this.beepers = beepers;
    }

    /**
     * Returns x-coordinate of the robot's position in the world.
     *
     * @return x-coordinate of the robot's position in the world
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Sets x-coordinate of the robot's position in the world.
     *
     * @param posX x-coordinate of the robot's position in the world
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * Returns y-coordinate of the robot's position in the world.
     *
     * @return y-coordinate of the robot's position in the world
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Sets y-coordinate of the robot's position in the world.
     *
     * @param posY y-coordinate of the robot's position in the world
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void turnLeft() {
        switch (facing) {
            case NORTH:
                facing = Direction.WEST;
                break;
            case WEST:
                facing = Direction.SOUTH;
                break;
            case SOUTH:
                facing = Direction.EAST;
                break;
            case EAST:
                facing = Direction.NORTH;
                break;
        }
    }

    public void move() {
        switch (facing) {
            case NORTH:
                posY--;
                break;
            case SOUTH:
                posY++;
                break;
            case WEST:
                posX--;
                break;
            case EAST:
                posX++;
                break;
        }
    }

    @Override
    public String toString() {
        return "posX=" + posX + ", posY=" + posY + ", direction=" + facing + ", beepers=" + beepers;
    }

    void print() {
        switch (facing) {
            case NORTH:
                System.out.print('A');
                break;
            case SOUTH:
                System.out.print('V');
                break;
            case WEST:
                System.out.print('<');
                break;
            case EAST:
                System.out.print('>');
                break;
        }
    }
}
