package yajco.example.json;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import yajco.example.json.parser.JsonParser;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
		String input = "{\n" +
				"\"id\": 444,\n" +
				"\"gender\": \"male\",\n" +
				"\"name\": \"John Bell\",\n" +
				"\"active\": true,\n" +
				"\"age\": 345,\n" +
				"\"hobbies\": [\"skiing\",\"sleeping\"]\n" +
				"}\n";
		parse(input);

		Assert.assertEquals("Cislo: 444\n" +
						"String: id\n" +
						"Hodnota retazca/value: male\n" +
						"String: gender\n" +
						"Hodnota retazca/value: John Bell\n" +
						"String: name\n" +
						"Booleanovska hodnota: true\n" +
						"String: active\n" +
						"Cislo: 345\n" +
						"String: age\n" +
						"Hodnota retazca/value: skiing\n" +
						"Hodnota retazca/value: sleeping\n" +
						"Zaciatok pola\n" +
						"Koniec pola\n" +
						"String: hobbies\n" +
						"Zaciatok objektu\n" +
						"Koniec objektu\n",
				outContent.toString());
	}

	@Test
	public void complexObjectTest() throws Exception {
		String input = "{\n" +
				"\"id\": 444,\n" +
				"\"gender\": \"male\",\n" +
				"\"name\": \"John Bell\",\n" +
				"\"active\": true,\n" +
				"\"age\": 345,\n" +
				"\"hobbies\": [\"skiing\",\"sleeping\"],\n" +
				"\"children\": [\n" +
				"{\n" +
				"\"id\": 445,\n" +
				"\"gender\": \"male\",\n" +
				"\"name\": \"Peter Bell\",\n" +
				"\"active\": true,\n" +
				"\"age\": 15,\n" +
				"\"hobbies\": [\"skiing\",\"reading\"]\n" +
				"},\n" +
				"{\n" +
				"\"id\": 446,\n" +
				"\"gender\": \"female\",\n" +
				"\"name\": \"Anna Bell\",\n" +
				"\"active\": false,\n" +
				"\"age\": 17,\n" +
				"\"hobbies\": [\"music\",\"dancing\"]\n" +
				"}\n" +
				"]\n" +
				"}\n";
		parse(input);

		Assert.assertEquals("Cislo: 444\n" +
						"String: id\n" +
						"Hodnota retazca/value: male\n" +
						"String: gender\n" +
						"Hodnota retazca/value: John Bell\n" +
						"String: name\n" +
						"Booleanovska hodnota: true\n" +
						"String: active\n" +
						"Cislo: 345\n" +
						"String: age\n" +
						"Hodnota retazca/value: skiing\n" +
						"Hodnota retazca/value: sleeping\n" +
						"Zaciatok pola\n" +
						"Koniec pola\n" +
						"String: hobbies\n" +
						"Cislo: 445\n" +
						"String: id\n" +
						"Hodnota retazca/value: male\n" +
						"String: gender\n" +
						"Hodnota retazca/value: Peter Bell\n" +
						"String: name\n" +
						"Booleanovska hodnota: true\n" +
						"String: active\n" +
						"Cislo: 15\n" +
						"String: age\n" +
						"Hodnota retazca/value: skiing\n" +
						"Hodnota retazca/value: reading\n" +
						"Zaciatok pola\n" +
						"Koniec pola\n" +
						"String: hobbies\n" +
						"Zaciatok objektu\n" +
						"Koniec objektu\n" +
						"Cislo: 446\n" +
						"String: id\n" +
						"Hodnota retazca/value: female\n" +
						"String: gender\n" +
						"Hodnota retazca/value: Anna Bell\n" +
						"String: name\n" +
						"Booleanovska hodnota: false\n" +
						"String: active\n" +
						"Cislo: 17\n" +
						"String: age\n" +
						"Hodnota retazca/value: music\n" +
						"Hodnota retazca/value: dancing\n" +
						"Zaciatok pola\n" +
						"Koniec pola\n" +
						"String: hobbies\n" +
						"Zaciatok objektu\n" +
						"Koniec objektu\n" +
						"Zaciatok pola\n" +
						"Koniec pola\n" +
						"String: children\n" +
						"Zaciatok objektu\n" +
						"Koniec objektu\n",
				outContent.toString());
	}

	private void parse(String input) throws Exception {
		JsonParser parser = new JsonParser();
		parser.parse(input);
	}
}
