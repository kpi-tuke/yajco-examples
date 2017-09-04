package yajco.example.json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import yajco.example.json.model.JsonFile;
import yajco.example.json.parser.ParseException;
import yajco.example.json.parser.JsonParser;


public class Main {
    public static void main(String[] args) throws ParseException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("/input.txt")));
	JsonParser parser = new JsonParser();
        JsonFile jsonFile = parser.parse(reader);

	}
}
