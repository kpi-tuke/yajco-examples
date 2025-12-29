package yajco.robot;

import yajco.robot.model.Robot;
import yajco.robot.model.parser.Parser;

import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        InputStream in = Main.class.getResourceAsStream("/karel.robot");
        if (in == null) throw new RuntimeException("/karel.robot not found");

        Robot robot = new Parser().parse(new InputStreamReader(in));
        robot.run();
    }
}
