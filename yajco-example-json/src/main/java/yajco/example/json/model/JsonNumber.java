package yajco.example.json.model;

import yajco.annotation.Token;

import java.text.NumberFormat;
import java.util.Locale;

public class JsonNumber extends JsonValue {

    private double value;

    public JsonNumber(@Token("NUMBER") String number){
        this.value = Double.parseDouble(number);
    }

    public Double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return NumberFormat.getInstance(Locale.ROOT).format(value);
    }
}
