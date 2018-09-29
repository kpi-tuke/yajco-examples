package yajco.example.json;

import yajco.example.json.model.JsonValue;
import yajco.example.json.parser.ParseException;

import java.io.InputStream;


public class Main {
    public static void main(String[] args) throws ParseException {
        InputStream stream = Main.class.getResourceAsStream("/input.json" );
        JsonValue jsonFile = new JsonReader().parse(stream);
        System.out.println(jsonFile);
    }
}
