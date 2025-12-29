package yajco.robot.model;

import yajco.annotation.Before;

public class TurnLeft implements Command {

    @Before("turn-left")
    public TurnLeft() {
    }

    @Override
    public void execute() {
        System.out.println("turning left");
    }
}
