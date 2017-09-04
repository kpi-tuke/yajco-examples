package yajco.robot;

import yajco.robot.model.Robot;
import yajco.robot.model.parser.Parser;

import java.io.FileReader;

/**
 *
 * @author DeeL
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        Parser parser = new Parser();
        Robot robot = parser.parse(new FileReader("karel.robot"));
        robot.run();
    }
    
}
