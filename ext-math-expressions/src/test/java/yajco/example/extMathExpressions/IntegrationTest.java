package yajco.example.extMathExpressions;

import org.junit.Assert;
import org.junit.Test;
import yajco.example.extMathExpr.model.Expression;
import yajco.example.extMathExpr.parser.ExpressionParser;

public class IntegrationTest {
    @Test
    public void simpleExampleTest() throws Exception {
        Assert.assertEquals(-56, getResult("2 ^ 3 * -7"));
    }

    @Test
    public void complexExampleTest() throws Exception {
        Assert.assertEquals(174, getResult("3^2 + (54/2)^2 - 6*5^2 + 4! * (2+ 3!*2)"));
    }

    @Test
    public void factorialTest() throws Exception {
        Assert.assertEquals(120, getResult("5!"));
    }

    @Test
    public void oppositeNumbersMultiplicationTest() throws Exception {
        Assert.assertEquals(-25, getResult("-5 * 5"));
    }

    @Test
    public void negativeNumbersMultiplicationTest() throws Exception {
        Assert.assertEquals(25, getResult("-5 * -5"));
    }

    @Test
    public void doubleMinusTest() throws Exception {
        Assert.assertEquals(5, getResult("--5"));
    }

    private long getResult(String input) throws Exception {
        ExpressionParser parser = new ExpressionParser();
        Expression expr = parser.parse(input);
        return expr.eval();
    }
}
