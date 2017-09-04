package yajco.example.sml.model;

import javax.annotation.PostConstruct;
import yajco.annotation.After;
import yajco.annotation.Before;
import yajco.annotation.Token;
import yajco.annotation.reference.References;

public class Transition extends Declaration {

    private String label;

    private State source;

    private State target;

    @Before("trans")
    @After(";")
    public Transition(
            @Token("ID") String label,
            @Before(":")
            @Token("ID")
            @References(value = State.class, field = "source") String sourceLabel,
            @Before("->")
            @Token("ID")
            @References(value = State.class, field = "target") String targetLabel) {
        this.label = label;
    }

    @PostConstruct
    public void test() {
        source.getOutgoingTransitions().add(this);
        target.getIncomingTransitions().add(this);
    }

    public String getLabel() {
        return label;
    }

    public State getSource() {
        return source;
    }

    public State getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return String.format("trans %s:%s->%s;", label, source.getLabel(), target.getLabel());
    }
}
