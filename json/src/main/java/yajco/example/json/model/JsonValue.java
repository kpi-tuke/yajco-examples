package yajco.example.json.model;

public abstract class JsonValue {
    public abstract Object getValue();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JsonValue)) return false;

        JsonValue that = (JsonValue) o;

        return getValue() != null ? getValue().equals(that.getValue()) : that.getValue() == null;
    }

    @Override
    public int hashCode() {
        return getValue() != null ? getValue().hashCode() : 0;
    }
}
