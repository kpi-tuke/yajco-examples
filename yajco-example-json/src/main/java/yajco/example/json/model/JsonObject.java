package yajco.example.json.model;

import yajco.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonObject extends JsonValue {
    private List<Member> members;

    @Before("{")
    @After("}")
    public JsonObject(@Separator(",") List<Member> members) {
        this.members = members;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @Override
    public Map<JsonString, JsonValue> getValue() {
        Map<JsonString, JsonValue> map = new HashMap<>();
        for (Member m : members) {
            map.put(m.getName(), m.getValue());
        }
        return map;
    }

    @Override
    public String toString() {
        List<String> members = this.members.stream()
                .map(Member::toString)
                .collect(Collectors.toList());
        return "{" + String.join(", ", members) + "}";
    }
}
