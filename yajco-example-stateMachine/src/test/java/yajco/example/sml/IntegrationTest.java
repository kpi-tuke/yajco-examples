package yajco.example.sml;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import yajco.example.sml.model.Declaration;
import yajco.example.sml.model.State;
import yajco.example.sml.model.StateMachine;
import yajco.example.sml.model.Transition;
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

		StateMachine parsedStateMachine = parseStateMachine(input);
		StateMachine stateMachine = getSimpleStateMachine();

		Assert.assertTrue(stateMachine.equals(parsedStateMachine));
	}

	@Test
	public void testComplexExample() throws Exception {
		String input = "state Idle;\n" +
				"state InsertingCoins;\n" +
				"state UserChoose;\n" +
				"state MakingCoffee;\n" +
				"state ServiceNeeded;\n" +
				"\n" +
				"trans coinsInsert : Idle -> InsertingCoins;\n" +
				"trans coinsReturn : InsertingCoins -> Idle;\n" +
				"trans rightAmountEntered : InsertingCoins -> UserChoose;\n" +
				"trans buttonPush : UserChoose -> MakingCoffee;\n" +
				"trans cupTaken : MakingCoffee -> Idle;\n" +
				"trans error : MakingCoffee -> ServiceNeeded;\n" +
				"trans resetButton : ServiceNeeded -> Idle;\n";

		StateMachine parsedStateMachine = parseStateMachine(input);
		StateMachine stateMachine = getComplexStateMachine();

		Assert.assertTrue(stateMachine.equals(parsedStateMachine));

	}

	private StateMachine getSimpleStateMachine() {
		State ready = new State("Ready");
		State running = new State("Running");
		State unsafe = new State("Unsafe");

		Transition a = new Transition("a", ready, running);
		Transition b = new Transition("b", running, ready);
		Transition c = new Transition("c", running, unsafe);
		Transition d = new Transition("d", unsafe, running);

		ready.getIncomingTransitions().add(b);
		ready.getOutgoingTransitions().add(a);

		running.getIncomingTransitions().add(a);
		running.getIncomingTransitions().add(d);
		running.getOutgoingTransitions().add(b);
		running.getOutgoingTransitions().add(c);

		unsafe.getIncomingTransitions().add(c);
		unsafe.getOutgoingTransitions().add(d);

		Declaration[] declarations = new Declaration[]{ready, running, unsafe, a, b, c, d};
		return new StateMachine(declarations);
	}

	private StateMachine getComplexStateMachine() {
		State idle = new State("Idle");
		State insertingCoins = new State("InsertingCoins");
		State userChoose = new State("UserChoose");
		State makingCoffee = new State("MakingCoffee");
		State serviceNeeded = new State("ServiceNeeded");

		Transition coinsInsert = new Transition("coinsInsert", idle, insertingCoins);
		Transition coinsReturn = new Transition("coinsReturn", insertingCoins, idle);
		Transition rightAmountEntered = new Transition("rightAmountEntered", insertingCoins, userChoose);
		Transition buttonPush = new Transition("buttonPush", userChoose, makingCoffee);
		Transition cupTaken = new Transition("cupTaken", makingCoffee, idle);
		Transition error = new Transition("error", makingCoffee, serviceNeeded);
		Transition resetButton = new Transition("resetButton", serviceNeeded, idle);

		idle.getIncomingTransitions().add(coinsReturn);
		idle.getIncomingTransitions().add(cupTaken);
		idle.getIncomingTransitions().add(resetButton);
		idle.getOutgoingTransitions().add(coinsInsert);

		insertingCoins.getIncomingTransitions().add(coinsInsert);
		insertingCoins.getOutgoingTransitions().add(coinsReturn);
		insertingCoins.getOutgoingTransitions().add(rightAmountEntered);

		userChoose.getIncomingTransitions().add(rightAmountEntered);
		userChoose.getOutgoingTransitions().add(buttonPush);

		makingCoffee.getIncomingTransitions().add(buttonPush);
		makingCoffee.getOutgoingTransitions().add(cupTaken);
		makingCoffee.getOutgoingTransitions().add(error);

		serviceNeeded.getIncomingTransitions().add(error);
		serviceNeeded.getOutgoingTransitions().add(resetButton);

		Declaration[] declarations = new Declaration[]{
				idle,
				insertingCoins,
				userChoose,
				makingCoffee,
				serviceNeeded,
				coinsInsert,
				coinsReturn,
				rightAmountEntered,
				buttonPush,
				cupTaken,
				error,
				resetButton
		};

		return new StateMachine(declarations);
	}

	private StateMachine parseStateMachine(String input) throws Exception {
		return new StateMachineParser().parse(input);
	}
}
