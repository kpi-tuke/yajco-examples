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
						"state Running [outgoingTrans: c b ; incomingTrans: a d ];\n" +
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
				"state ReturningRemnant;\n" +
				"state MakeCoffee;\n" +
				"\n" +
				"trans a : Idle -> InsertingCoins;\n" +
				"trans b : InsertingCoins -> UserChoose;\n" +
				"trans c : UserChoose -> ReturningRemnant;\n" +
				"trans d : ReturningRemnant -> MakeCoffee;\n" +
				"trans e : MakeCoffee -> Idle;\n";

		parseStateMachine(input);
		Assert.assertEquals("state Idle [outgoingTrans: a ; incomingTrans: e ];\n" +
						"state InsertingCoins [outgoingTrans: b ; incomingTrans: a ];\n" +
						"state UserChoose [outgoingTrans: c ; incomingTrans: b ];\n" +
						"state ReturningRemnant [outgoingTrans: d ; incomingTrans: c ];\n" +
						"state MakeCoffee [outgoingTrans: e ; incomingTrans: d ];\n" +
						"trans a:Idle->InsertingCoins;\n" +
						"trans b:InsertingCoins->UserChoose;\n" +
						"trans c:UserChoose->ReturningRemnant;\n" +
						"trans d:ReturningRemnant->MakeCoffee;\n" +
						"trans e:MakeCoffee->Idle;\n" +
						"\n",
				outContent.toString());
	}

	private void parseStateMachine(String input) throws Exception {
		StateMachine machine = new StateMachineParser().parse(input);

		System.out.println(machine);
	}
}
