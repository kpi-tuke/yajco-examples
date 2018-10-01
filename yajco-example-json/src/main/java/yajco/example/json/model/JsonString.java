package yajco.example.json.model;

import yajco.annotation.Token;

public class JsonString extends JsonValue {
    private String value;

    public JsonString(@Token("STRING") String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "\"" + value + '\"';
    }
}
