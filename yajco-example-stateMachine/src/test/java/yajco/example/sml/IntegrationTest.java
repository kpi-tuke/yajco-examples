package yajco.example.sml;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import yajco.example.sml.model.StateMachine;
import yajco.exemple.sml.parser.ParseException;
import yajco.exemple.sml.parser.StateMachineParser;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class IntegrationTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void restoreStreams() {
		System.setOut(System.out);
	}

	@Test
	public void testSimpleExample() throws Exception {
		String input = "state Ready;\n" +
				"state Running;\n" +
				"state Unsafe;\n" +
				"\n" +
				"trans a : Ready -> Running;\n" +
				"trans b : Running -> Ready;\n" +
				"trans c : Running -> Unsafe;\n" +
				"trans d : Unsafe -> Running;\n";

		parseStateMachine(input);
		Assert.assertEquals("state Ready [outgoingTrans: a ; incomingTrans: b ];\n" +
						"state Running [outgoingTrans: b c ; incomingTrans: a d ];\n" +
						"state Unsafe [outgoingTrans: d ; incomingTrans: c ];\n" +
						"trans a:Ready->Running;\n" +
						"trans b:Running->Ready;\n" +
						"trans c:Running->Unsafe;\n" +
						"trans d:Unsafe->Running;\n\n",
				outContent.toString());
	}

	@Test
	public void testComplexExample() throws Exception {
		String input = "state Idle;\n" +
				"state InsertingCoins;\n" +
				"state UserChoose;\n" +
				"state MakeCoffee;\n" +
				"state ServiceNeeded;\n" +
				"\n" +
				"trans a : Idle -> InsertingCoins;\n" +
				"trans b : InsertingCoins -> Idle;\n" +
				"trans c : InsertingCoins -> UserChoose;\n" +
				"trans d : UserChoose -> Idle;\n" +
				"trans e : UserChoose -> MakeCoffee;\n" +
				"trans f : MakeCoffee -> Idle;\n" +
				"trans g : MakeCoffee -> ServiceNeeded;\n" +
				"trans h : ServiceNeeded -> Idle;\n";

		parseStateMachine(input);
		Assert.assertEquals("state Idle [outgoingTrans: a ; incomingTrans: b h f d ];\n" +
						"state InsertingCoins [outgoingTrans: b c ; incomingTrans: a ];\n" +
						"state UserChoose [outgoingTrans: e d ; incomingTrans: c ];\n" +
						"state MakeCoffee [outgoingTrans: f g ; incomingTrans: e ];\n" +
						"state ServiceNeeded [outgoingTrans: h ; incomingTrans: g ];\n" +
						"trans a:Idle->InsertingCoins;\n" +
						"trans b:InsertingCoins->Idle;\n" +
						"trans c:InsertingCoins->UserChoose;\n" +
						"trans d:UserChoose->Idle;\n" +
						"trans e:UserChoose->MakeCoffee;\n" +
						"trans f:MakeCoffee->Idle;\n" +
						"trans g:MakeCoffee->ServiceNeeded;\n" +
						"trans h:ServiceNeeded->Idle;\n" +
						"\n",
				outContent.toString());
	}

	private void parseStateMachine(String input) throws Exception {
		StateMachine machine = new StateMachineParser().parse(input);

		System.out.println(machine);
	}
}
