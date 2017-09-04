package yajco.robot.model;

import java.util.List;
import yajco.annotation.After;
import yajco.annotation.Before;

/**
 *
 * @author DeeL
 */
public class Robot {
    List<Command> commands;

    @Before("begin")
    @After("end")
    public Robot(List<Command> commands) {
        this.commands = commands;
    }

    public List<Command> getCommands() {
        return commands;
    }
    
    public void run() {
        for (Command command : commands) {
            command.execute();
        }
    }
    
}
