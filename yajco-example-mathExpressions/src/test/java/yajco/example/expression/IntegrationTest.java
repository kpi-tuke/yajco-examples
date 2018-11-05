package yajco.example.expression;

import org.junit.Assert;
import org.junit.Test;
import yajco.example.expression.model.Expression;
import yajco.example.parser.ExpressionParser;

public class IntegrationTest {
	@Test
	public void additionTest() throws Exception {
		Assert.assertEquals(128, getResult("29+99"));
	}

	@Test
	public void subtractionTest() throws Exception {
		Assert.assertEquals(-5, getResult("20-25"));
	}

	@Test
	public void multiplicationTest() throws Exception {
		Assert.assertEquals(30, getResult("6*5"));
	}

	@Test
	public void divisionTest() throws Exception {
		Assert.assertEquals(13, getResult("26/2"));
	}

	@Test
	public void simpleExampleTest() throws Exception {
		Assert.assertEquals(120, getResult("(1+6/2)*30"));
	}

	@Test
	public void complexExampleTest() throws Exception {
		Assert.assertEquals(32, getResult("2+5*(30/5)/3+5*4"));
	}

	private long getResult(String input) throws Exception {
		ExpressionParser parser = new ExpressionParser();
		Expression expr = parser.parse(input);
		return expr.eval();
	}
}
