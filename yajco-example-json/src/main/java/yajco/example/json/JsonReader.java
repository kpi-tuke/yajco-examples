package yajco.example.json;

import yajco.example.json.model.JsonValue;
import yajco.example.json.parser.JsonParser;
import yajco.example.json.parser.ParseException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonReader {
    public JsonValue parse(InputStream stream) throws ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        JsonParser parser = new JsonParser();
        return parser.parse(reader);
    }
}
