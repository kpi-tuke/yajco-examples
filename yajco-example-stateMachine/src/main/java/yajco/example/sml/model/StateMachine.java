package yajco.example.sml.model;

import java.util.Arrays;

public class StateMachine {

    private final State[] states;
    private final Transition[] transitions;

    public StateMachine(State[] states, Transition[] transitions) {
        this.states = states;
        this.transitions = transitions;
    }

    public State[] getStates() {
        return states;
    }

    public Transition[] getTransitions() {
        return transitions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (State state : states) {
            sb.append(state.toString());
            sb.append('\n');
        }
        for (Transition transition : transitions) {
            sb.append(transition.toString());
            sb.append('\n');
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StateMachine)) return false;

        StateMachine that = (StateMachine) o;
        return Arrays.equals(getStates(), that.getStates()) && Arrays.equals(getTransitions(), that.getTransitions());
    }
}
