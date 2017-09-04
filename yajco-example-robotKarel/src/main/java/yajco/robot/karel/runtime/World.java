package yajco.robot.karel.runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents robot's world with obstacles (walls) and beepers.
 * There is one robot Karel in the world.
 * @author jaro
 */
public class World {
    /** Robot's sides. */
    public static final int FRONT = 0,  RIGHT = 90,  BACK = 180,  LEFT = 270;

    /** Karel the robot in the world. */
    private final Robot karel = new Robot();

    /**
     * World map. Map is represented as a list of string.
     * One character in the string represents content on the map - beeper, obstacle, empty place.
     */
    private List<StringBuilder> map;

    /** Characters for encoding the content in the world map. */
    private static final char ROBOT_CHAR = 'K',  BEEPER_CHAR = 'o',  OBSTACLE_CHAR = '*',  EMPTY_CHAR = ' ';

    /**
     * Returns Karel the robot object from the world.
     * @return Karel the robot
     */
    public Robot getKarel() {
        return karel;
    }

    /**
     * Converts an angle into x offset.
     * 0 -> 0, 90 -> +1, 180 -> 0, 270 -> -1
     * @param angle to convert
     * @return offset on x-coordinate
     */
    public int angleToOffsetX(int angle) {
        return (180 - angle) % 180 / 90;
    }

    /**
     * Converts an angle into y offset.
     * 0 -> -1, 90 -> 0, 180 -> +1, 270 -> 0
     * @param angle to convert
     * @return offset on x-coordinate
     */
    public int angleToOffsetY(int angle) {
        return (angle - 90) % 180 / 90;
    }

    /**
     * Tests a position for obstacle existence.
     * @param x x-coordinate of a position
     * @param y y-coordinate of a position
     * @return true if obstacle is on a position
     */
    public boolean isObstacleOn(int x, int y) {
        return !isValidPosition(x, y) || getContentOnPosition(x, y) == OBSTACLE_CHAR;
    }

    /**
     * Tests a position for beeper existence.
     * @param x x-coordinate of a position
     * @param y y-coordinate of a position
     * @return true if beeper is on a position
     */
    public boolean isBeeperOn(int x, int y) {
        return isValidPosition(x, y) && getContentOnPosition(x, y) == BEEPER_CHAR;
    }

    /**
     * Gets a beeper from a position.
     * If the position does not exist the expception is thrown.
     * @param x x-coordinate of a position
     * @param y y-coordinate of a position
     */
    public void getBeeperFrom(int x, int y) {
        if (isValidPosition(x, y)) {
            StringBuilder line = map.get(y);
            line.setCharAt(x, EMPTY_CHAR);
        } else {
            throw new RuntimeException("Invalid position (" + x + ", " + y + ")!");
        }
    }

    /**
     * Puts the beeper on a position.
     * If the position does not exist the expception is thrown.
     *
     * @param x x-coordinate of a position
     * @param y y-coordinate of a position
     */
    public void putBeeperOn(int x, int y) {
        if (isValidPosition(x, y)) {
            StringBuilder line = map.get(y);
            line.setCharAt(x, BEEPER_CHAR);
        } else {
            throw new RuntimeException("Invalid position (" + x + ", " + y + ")!");
        }
    }

    /**
     * Returns true if specified position is valid.
     * @param x x-coordinate of a position
     * @param y y-coordinate of a position
     * @return true if specified position is valid.
     */
    private boolean isValidPosition(int x, int y) {
        return x >= 0 && y >= 0 && y < map.size() && x < map.get(y).length();
    }

    /**
     * Returns content on specified position.
     * @param x x-coordinate of a position
     * @param y y-coordinate of a position
     * @return  content on specified position.
     */
    private char getContentOnPosition(int x, int y) {
        return map.get(y).charAt(x);
    }

    /**
     * Loads a world map from
     * @param reader    reader
     * @throws java.io.IOException  exception during reading
     */
    public void load(Reader reader) throws IOException {
        map = new ArrayList<StringBuilder>();
        BufferedReader r = new BufferedReader(reader);
        String line;
        while ((line = r.readLine()) != null) {
            map.add(new StringBuilder(line));
        }

        initRobotPosition();
    }

    /**
     * Initializes robot position from the loaded map.
     */
    private void initRobotPosition() {
        for (int y = 0; y < map.size(); y++) {
            StringBuilder sb = map.get(y);
            for (int x = 0; x < sb.length(); x++) {
                if (getContentOnPosition(x, y) == ROBOT_CHAR) {
                    karel.setPosX(x);
                    karel.setPosY(y);
                    return;
                }
            }
        }
        throw new RuntimeException("Invalid map! Missing robot on map (sign '" + ROBOT_CHAR + "').");
    }

    /**
     * Prints the map.
     */
    public void print() {
        for (int y = 0; y < map.size(); y++) {
            StringBuilder sb = map.get(y);
            for (int x = 0; x < sb.length(); x++) {
                if (x == karel.getPosX() && y == karel.getPosY()) {
                    printKarel();
                } else {
                    System.out.print(sb.charAt(x));
                }
            }
            System.out.println();
        }
    }

    /**
     * Prints Karel on the position.
     */
    private void printKarel() {
        karel.print();
    }

    @Override
    public String toString() {
        return "Karel: " + karel.toString();
    }
}
