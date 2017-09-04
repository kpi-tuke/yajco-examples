package yajco.robot.model;

import yajco.annotation.Before;

/**
 *
 * @author DeeL
 */
public class TurnLeft implements Command{
    
    private String hocico;

    @Before("turn-left")
    public TurnLeft() {
    }
    
    @Override
    public void execute() {
        System.out.println("turning left");
    }
}
