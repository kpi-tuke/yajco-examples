package yajco.example.json.model;

import yajco.annotation.Token;

public class JsonBoolean extends JsonValue {

    private boolean value;

    public JsonBoolean(@Token("BOOLEAN") boolean value){
        this.value = value;
    }

    @Override
    public Boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
