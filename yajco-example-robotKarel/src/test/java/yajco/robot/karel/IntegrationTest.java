package yajco.robot.karel;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import yajco.robot.karel.model.Program;
import yajco.robot.karel.parser.Parser;
import yajco.robot.karel.runtime.World;

import java.io.*;
import java.nio.file.Files;

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
        runRobot("simpleProgram.kar");
        Assert.assertEquals(getFileContent("simpleProgramOutput.txt"), outContent.toString());
    }

    @Test
    public void testComplexProgramExecution() throws Exception {
        runRobot("complexProgram.kar");
        Assert.assertEquals(getFileContent("complexProgramOutput.txt"), outContent.toString());
    }

    private void runRobot(String source) throws Exception {
        World world = new World();
        world.load(new FileReader("level1.map"));

        Program program = new Parser().parse(getFileContent(source));

        program.execute(world);
        world.print();
    }

    private String getFileContent(String fileName){
        File file = new File(this.getClass().getClassLoader().getResource(fileName).getFile());

        String content = null;
        try {
            content = new String(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }
}
