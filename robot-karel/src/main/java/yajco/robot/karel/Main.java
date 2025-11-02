package yajco.robot.karel;

import java.io.InputStream;
import java.io.InputStreamReader;

import yajco.robot.karel.model.Program;
import yajco.robot.karel.runtime.World;
import yajco.robot.karel.parser.Parser;

public class Main {
    public static void main(String[] args) throws Exception {
        InputStream mapStream = Main.class.getResourceAsStream("/level1.map");
        if (mapStream == null) throw new RuntimeException("/level1.map not found");

        InputStream programStream = Main.class.getResourceAsStream("/test.kar");
        if (programStream == null) throw new RuntimeException("/test.kar not found");

        World world = new World();
        world.load(new InputStreamReader(mapStream));

        Program program = new Parser().parse(new InputStreamReader(programStream));
        program.execute(world);

        world.print();
    }
}
