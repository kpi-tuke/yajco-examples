package yajco.example.json;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import yajco.example.json.model.JsonValue;
import yajco.example.json.parser.JsonParser;
import yajco.example.json.parser.ParseException;

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
	public void simpleObjectTest() throws Exception {
		String input = "/simple_input.json";
		Assert.assertEquals(getJsonObject(input).toString(), "{\"id\": 444, " +
				"\"gender\": \"male\", " +
				"\"name\": \"John Bell\", " +
				"\"active\": true, " +
				"\"age\": 34.5, " +
				"\"hobbies\": [\"skiing\", \"sleeping\"]" +
				"}");
	}

	@Test
	public void complexObjectTest() throws Exception {
		String input = "/complex_input.json";
		Assert.assertEquals(getJsonObject(input).toString(), "{\"id\": 444, " +
				"\"gender\": \"male\", " +
				"\"name\": \"John Bell\", " +
				"\"active\": true, " +
				"\"age\": 345, " +
				"\"hobbies\": [\"skiing\", \"sleeping\"], " +
				"\"children\": [{" +
				"\"id\": 445, " +
				"\"gender\": \"male\", " +
				"\"name\": \"Peter Bell\", " +
				"\"active\": true, " +
				"\"age\": 15, " +
				"\"hobbies\": [\"skiing\", \"reading\"]" +
				"}, " +
				"{" +
				"\"id\": 446, " +
				"\"gender\": \"female\", " +
				"\"name\": \"Anna Bell\", " +
				"\"active\": false, " +
				"\"age\": 17, " +
				"\"hobbies\": [\"music\", \"dancing\"]" +
				"}" +
				"]" +
				"}");
	}

	private JsonValue getJsonObject(String input) throws ParseException {
		InputStream stream = Main.class.getResourceAsStream(input);
		return new JsonReader().parse(stream);
	}
}
