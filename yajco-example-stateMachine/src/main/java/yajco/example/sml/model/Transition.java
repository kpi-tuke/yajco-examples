package yajco.example.sml.model;

import javax.annotation.PostConstruct;
import yajco.annotation.After;
import yajco.annotation.Before;
import yajco.annotation.Exclude;
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

    @Exclude
    public Transition(String label, State source, State target) {
        this.label = label;
        this.source = source;
        this.target = target;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transition)) return false;

        Transition that = (Transition) o;

        return getLabel().equals(that.getLabel()) && getSource().equals(that.getSource()) &&
                getTarget().equals(that.getTarget());
    }
}
