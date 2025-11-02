package yajco.robot.model;

import yajco.annotation.Before;

public class Move implements Command {

    @Before("move")
    public Move() {
    }

    @Override
    public void execute() {
        System.out.println("going straight");
    }
}
