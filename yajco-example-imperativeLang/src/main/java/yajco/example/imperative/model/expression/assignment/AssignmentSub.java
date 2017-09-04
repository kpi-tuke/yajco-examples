package yajco.example.imperative.model.expression.assignment;

import yajco.model.pattern.impl.Associativity;
import yajco.annotation.Before;
import yajco.annotation.Operator;
import yajco.example.imperative.model.expression.Expression;

public class AssignmentSub extends AssignmentGeneric {
    @Operator(priority = 1, associativity = Associativity.RIGHT)
    public AssignmentSub(Expression expression1, @Before("ASSIGNSUB") Expression expression2) {
        super(expression1, expression2);
    }

    @Override
    protected long eval(long value1, long value2) {
        return value1 - value2;
    }
}
