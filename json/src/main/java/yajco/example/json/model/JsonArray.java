package yajco.example.json.model;

import yajco.annotation.*;

import java.util.List;

public class JsonArray extends JsonValue {
    private List<JsonValue> value;

    @Before("[")
    @After("]")
    public JsonArray(@Separator(",") List<JsonValue> elements) {
        this.value = elements;
    }

    @Override
    public List<JsonValue> getValue() {
        return value;
    }

    public void setValue(List<JsonValue> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
