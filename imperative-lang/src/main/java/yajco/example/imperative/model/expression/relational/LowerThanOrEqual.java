package yajco.example.imperative.model.expression.relational;

import yajco.annotation.Before;
import yajco.annotation.Operator;
import yajco.example.imperative.model.expression.BinaryOperation;
import yajco.example.imperative.model.expression.Expression;

public final class LowerThanOrEqual extends BinaryOperation {
    @Operator(priority = 9)
    public LowerThanOrEqual(Expression expression1, @Before("LTE") Expression expression2) {
        super(expression1, expression2);
    }

    public long eval() {
        return getExpression1().eval() <= getExpression2().eval() ? 1 : 0;
    }
}
