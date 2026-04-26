package yajco.robot.karel;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import yajco.robot.karel.model.Program;
import yajco.robot.karel.parser.Parser;
import yajco.robot.karel.runtime.World;

import java.io.*;

public class IntegrationTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void testSimpleProgramExecution() throws Exception {
        runRobot("/simpleProgram.kar");
        Assert.assertEquals(getResourceContent("/simpleProgramOutput.txt"), outContent.toString());
    }

    @Test
    public void testComplexProgramExecution() throws Exception {
        runRobot("/complexProgram.kar");
        Assert.assertEquals(getResourceContent("/complexProgramOutput.txt"), outContent.toString());
    }

    private void runRobot(String programPath) throws Exception {
        InputStream mapStream = getClass().getResourceAsStream("/level1.map");
        if (mapStream == null) throw new RuntimeException("/level1.map not found");

        World world = new World();
        world.load(new InputStreamReader(mapStream));

        String source = getResourceContent(programPath);
        Program program = new Parser().parse(source);

        program.execute(world);
        world.print();
    }

    private String getResourceContent(String resourcePath) throws IOException {
        InputStream in = getClass().getResourceAsStream(resourcePath);
        if (in == null) throw new FileNotFoundException(resourcePath + " not found");
        return new String(in.readAllBytes());
    }
}
