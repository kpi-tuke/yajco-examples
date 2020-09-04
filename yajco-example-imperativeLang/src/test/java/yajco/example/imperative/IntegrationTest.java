package yajco.example.imperative;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import yajco.example.imperative.machine.Machine;
import yajco.example.imperative.model.Program;
import yajco.example.imperative.parser.Parser;

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
    public void simpleExampleTest() throws Exception {
        executeProgram("/simpleProgram");
        Assert.assertEquals("10\n" +
                "9\n" +
                "8\n" +
                "7\n" +
                "6\n" +
                "5\n" +
                "4\n" +
                "3\n" +
                "2\n" +
                "1\n" +
                "0\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "4\n" +
                "5\n" +
                "6\n" +
                "7\n" +
                "8\n" +
                "9\n" +
                "10\n" +
                "{a=39845888, b=0, c=20, i=11}\n",
                outContent.toString());
    }

    @Test
    public void complexExampleTest() throws Exception {
        executeProgram("/complexProgram");
        Assert.assertEquals("17\n" +
                "18\n" +
                "19\n" +
                "20\n" +
                "21\n" +
                "22\n" +
                "23\n" +
                "24\n" +
                "25\n" +
                "26\n" +
                "{a=39845888, b=0, c=20}\n",
                outContent.toString());
    }

    private void executeProgram(String source) throws Exception {
        Reader reader = new BufferedReader(new InputStreamReader(
                Main.class.getResourceAsStream(source)));
        Program program = new Parser().parse(reader);

        program.execute();
        System.out.println(Machine.getInstance());
    }


}
