package yajco.robot.model;

import yajco.annotation.Before;

/**
 *
 * @author DeeL
 */
public class Move implements Command{

    @Before("move")
    public Move() {
    }

    @Override
    public void execute() {
        System.out.println("going straight");
    }
}
