package yajco.robot.karel;

import java.io.FileReader;
import yajco.robot.karel.model.Program;
import yajco.robot.karel.runtime.World;
import yajco.robot.karel.parser.Parser;

public class FileMain {
    public static void main(String[] args) throws Exception {
        World world = new World();
        world.load(new FileReader("level1.map"));

        //Program program = new Parser().parse(new FileReader(args[0]));
        Program program = new Parser().parse(new FileReader("test.kar"));

        program.execute(world);

        world.print();
    }
}
