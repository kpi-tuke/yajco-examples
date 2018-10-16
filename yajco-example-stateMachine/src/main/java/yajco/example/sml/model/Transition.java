package yajco.example.sml.model;

import javax.annotation.PostConstruct;
import yajco.annotation.After;
import yajco.annotation.Before;
import yajco.annotation.Token;
import yajco.annotation.reference.References;

public class Transition {

    private String label;
    private State source;
    private State target;

    @Before("trans")
    @After(";")
    public Transition(
            @Token("ID") String label,
            @Before(":")
            @Token("ID")
            @References(value = State.class, field = "source") String source,
            @Before("->")
            @Token("ID")
            @References(value = State.class, field = "target") String target) {
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

    public void setSource(State source) {
        this.source = source;
    }

    public void setTarget(State target) {
        this.target = target;
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
