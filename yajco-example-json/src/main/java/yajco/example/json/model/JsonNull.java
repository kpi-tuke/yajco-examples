package yajco.example.json.model;

import yajco.annotation.Before;

public class JsonNull extends JsonValue {

    @Before("NULL")
    public JsonNull(){
    }

    public Object getValue() {
        return null;
    }

    @Override
    public String toString() {
        return "null";
    }
}
