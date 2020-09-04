package yajco.example.desk;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import yajco.example.desk.model.Program;
import yajco.example.desk.model.printer.Printer;
import yajco.example.desk.parser.DeskParser;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

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
    public void simpleExampleCodeTest() throws Exception {
        String input = "print x + y + 3 + 2 where x = 1, y = 2";
        Assert.assertEquals("PUSH 2\n" +
                "PUSH 3\n" +
                "PUSH 2\n" +
                "PUSH 1\n" +
                "ADD\n" +
                "ADD\n" +
                "ADD\n",
                getProgramCode(input));
    }

    @Test
    public void simpleExamplePrinterOutputTest() throws Exception {
        String input = "print x + y + 3 + 2 where x = 1, y = 2";
        getPrinterOutput(input);
        Assert.assertEquals("print(((( x) +( y)) +( 3)) +( 2)) where x = 1, y = 2\n", outContent.toString());
    }

    @Test
    public void complexExampleCodeTest() throws Exception {
        String input = "print x + 15 + y + 25 + z where x = 18, y = 32, z = 34";
        Assert.assertEquals("PUSH 34\n" +
                "PUSH 25\n" +
                "PUSH 32\n" +
                "PUSH 15\n" +
                "PUSH 18\n" +
                "ADD\n" +
                "ADD\n" +
                "ADD\n" +
                "ADD\n",
                getProgramCode(input));
    }

    @Test
    public void complexExamplePrinterOutputTest() throws Exception {
        String input = "print x + 15 + y + 25 + z where x = 18, y = 32, z = 34";
        getPrinterOutput(input);
        Assert.assertEquals("print((((( x) +( 15)) +( y)) +( 25)) +( z)) where x = 18, y = 32, z = 34\n", outContent.toString());
    }

    private String getProgramCode(String input) throws Exception {
        Program program = new DeskParser().parse(input);
        return program.code();
    }

    private void getPrinterOutput(String input) throws Exception {
        Program program = new DeskParser().parse(input);
        Printer printer = new Printer();
        printer.print(program, new PrintWriter(System.out));
    }
}
