package yajco.example.sml;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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

		Transition a = new Transition("a", ready.getLabel(), running.getLabel());
		a.setSource(ready);
		a.setTarget(running);

		Transition b = new Transition("b", running.getLabel(), ready.getLabel());
		b.setSource(running);
		b.setTarget(ready);

		Transition c = new Transition("c", running.getLabel(), unsafe.getLabel());
		c.setSource(running);
		c.setTarget(unsafe);

		Transition d = new Transition("d", unsafe.getLabel(), running.getLabel());
		d.setSource(unsafe);
		d.setTarget(running);

		ready.getIncomingTransitions().add(b);
		ready.getOutgoingTransitions().add(a);

		running.getIncomingTransitions().add(a);
		running.getIncomingTransitions().add(d);
		running.getOutgoingTransitions().add(b);
		running.getOutgoingTransitions().add(c);

		unsafe.getIncomingTransitions().add(c);
		unsafe.getOutgoingTransitions().add(d);

		State[] states = new State[]{ready, running, unsafe};
		Transition[] transitions = new Transition[]{a, b, c, d};
		return new StateMachine(states, transitions);
	}

	private StateMachine getComplexStateMachine() {
		State idle = new State("Idle");
		State insertingCoins = new State("InsertingCoins");
		State userChoose = new State("UserChoose");
		State makingCoffee = new State("MakingCoffee");
		State serviceNeeded = new State("ServiceNeeded");

		Transition coinsInsert = new Transition("coinsInsert", idle.getLabel(), insertingCoins.getLabel());
		coinsInsert.setSource(idle);
		coinsInsert.setTarget(insertingCoins);

		Transition coinsReturn = new Transition("coinsReturn", insertingCoins.getLabel(), idle.getLabel());
		coinsReturn.setSource(insertingCoins);
		coinsReturn.setTarget(idle);

		Transition rightAmountEntered = new Transition("rightAmountEntered", insertingCoins.getLabel(), userChoose.getLabel());
		rightAmountEntered.setSource(insertingCoins);
		rightAmountEntered.setTarget(userChoose);

		Transition buttonPush = new Transition("buttonPush", userChoose.getLabel(), makingCoffee.getLabel());
		buttonPush.setSource(userChoose);
		buttonPush.setTarget(makingCoffee);

		Transition cupTaken = new Transition("cupTaken", makingCoffee.getLabel(), idle.getLabel());
		cupTaken.setSource(makingCoffee);
		cupTaken.setTarget(idle);

		Transition error = new Transition("error", makingCoffee.getLabel(), serviceNeeded.getLabel());
		error.setSource(makingCoffee);
		error.setTarget(serviceNeeded);

		Transition resetButton = new Transition("resetButton", serviceNeeded.getLabel(), idle.getLabel());
		resetButton.setSource(serviceNeeded);
		resetButton.setTarget(idle);

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

		State[] states = new State[]{idle, insertingCoins, userChoose, makingCoffee, serviceNeeded};
		Transition[] transitions = new Transition[]{coinsInsert, coinsReturn, rightAmountEntered, buttonPush, cupTaken, error, resetButton};

		return new StateMachine(states, transitions);
	}

	private StateMachine parseStateMachine(String input) throws Exception {
		return new StateMachineParser().parse(input);
	}
}
