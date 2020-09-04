package yajco.example.extMathExpressions;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import yajco.example.extMathExpr.model.Expression;
import yajco.example.extMathExpr.model.printer.Printer;
import yajco.example.extMathExpr.parser.ExpressionParser;
import yajco.example.extMathExpr.parser.ParseException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

import static org.hamcrest.core.StringContains.containsString;

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
        Assert.assertEquals(-56, getResult("2 ^ 3 * -7"));
        Assert.assertEquals("((( 2) \\^( 3)) \\*( -( 7)))\n", outContent.toString());
    }

    @Test
    public void complexExampleTest() throws Exception {
        Assert.assertEquals(174, getResult("3^2 + (54/2)^2 - 6*5^2 + 4! * (2+ 3!*2)"));
        Assert.assertThat(outContent.toString(), containsString("((((( 3) \\^( 2)) \\+((( 54) " +
                "/( 2)) \\^( 2))) -((( 6) \\*( 5)) \\^( 2))) \\+((( 4) !) \\*(( 2) \\+((( 3) !) \\*( 2)))))\n"));
    }

    @Test
    public void factorialTest() throws Exception {
        Assert.assertEquals(120, getResult("5!"));
        Assert.assertThat(outContent.toString(), containsString("(( 5) !)\n"));
    }

    @Test
    public void oppositeNumbersMultiplicationTest() throws Exception {
        Assert.assertEquals(-25, getResult("-5 * 5"));
        Assert.assertThat(outContent.toString(), containsString("(( -( 5)) \\*( 5))\n"));
    }

    @Test
    public void negativeNumbersMultiplicationTest() throws Exception {
        Assert.assertEquals(25, getResult("-5 * -5"));
        Assert.assertThat(outContent.toString(), containsString("(( -( 5)) \\*( -( 5)))\n"));
    }

    @Test
    public void doubleMinusTest() throws Exception {
        Assert.assertEquals(5, getResult("--5"));
        Assert.assertThat(outContent.toString(), containsString("( -( -( 5)))\n"));
    }

    private long getResult(String input) throws Exception {
        ExpressionParser parser = new ExpressionParser();
        Expression expr = parser.parse(input);

        Printer printer = new Printer();
        printer.print(expr, new PrintWriter(System.out));

        return expr.eval();
    }
}
