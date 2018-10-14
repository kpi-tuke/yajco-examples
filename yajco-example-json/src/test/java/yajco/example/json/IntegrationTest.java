package yajco.example.json;
import org.junit.Assert;
import org.junit.Test;
import yajco.example.json.model.*;
import yajco.example.json.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IntegrationTest {
	@Test
	public void simpleObjectTest() throws Exception {
		JsonObject createdObject = createSimpleJsonObject();
		JsonObject parsedObject = getParsedJsonObject("/simple_input.json");

		Assert.assertTrue(createdObject.equals(parsedObject));
	}

	@Test
	public void complexObjectTest() throws Exception {
		JsonObject createdObject = createComplexJsonObject();
		JsonObject parsedObject = getParsedJsonObject("/complex_input.json");

		Assert.assertTrue(createdObject.equals(parsedObject));
	}

	private JsonObject getParsedJsonObject(String input) throws ParseException {
		InputStream stream = Main.class.getResourceAsStream(input);
		return (JsonObject) new JsonReader().parse(stream);
	}

	private JsonObject createSimpleJsonObject() {
		List<String> hobbies = new ArrayList<>();
		hobbies.add("skiing");
		hobbies.add("sleeping");

		return createPersonObject("444", "male", "John Bell", true, "34.5", hobbies);
	}

	private JsonObject createComplexJsonObject() {
		List<String> firstChildHobbies = new ArrayList<>();
		firstChildHobbies.add("skiing");
		firstChildHobbies.add("reading");
		JsonObject firstChild = createPersonObject("445", "male", "Peter Bell", true, "15", firstChildHobbies);

		List<String> secondChildHobbies = new ArrayList<>();
		secondChildHobbies.add("music");
		secondChildHobbies.add("dancing");
		JsonObject secondChild = createPersonObject("446", "female", "Anna Bell", false, "17", secondChildHobbies);

		List<JsonValue> children = new ArrayList<>();
		children.add(firstChild);
		children.add(secondChild);

		JsonObject parent = createSimpleJsonObject();
		parent.getMembers().add(new Member(new JsonString("children"), new JsonArray(children)));

		return parent;
	}

	private JsonObject createPersonObject(String id, String gender, String name, boolean active, String age, List<String> hobbies) {
		List<JsonValue> hobbiesList = new ArrayList<>();
		for(String hobby: hobbies) {
			hobbiesList.add(new JsonString(hobby));
		}

		List<Member> members = new ArrayList<>();
		members.add(new Member(new JsonString("id"), new JsonNumber(id)));
		members.add(new Member(new JsonString("gender"), new JsonString(gender)));
		members.add(new Member(new JsonString("name"), new JsonString(name)));
		members.add(new Member(new JsonString("active"), new JsonBoolean(active)));
		members.add(new Member(new JsonString("age"), new JsonNumber(age)));
		members.add(new Member(new JsonString("hobbies"), new JsonArray(hobbiesList)));

		return new JsonObject(members);
	}
}
