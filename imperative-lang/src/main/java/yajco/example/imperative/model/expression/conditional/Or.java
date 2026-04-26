package yajco.example.imperative.model.expression.conditional;

import yajco.example.imperative.model.expression.Expression;
import yajco.annotation.Before;
import yajco.annotation.Operator;
import yajco.example.imperative.model.expression.BinaryOperation;

public final class Or extends BinaryOperation {
    @Operator(priority = 3)
    public Or(Expression expression1, @Before("OR") Expression expression2) {
        super(expression1, expression2);
    }

    public long eval() {
        return (getExpression1().eval() != 0 || getExpression2().eval() != 0) ? 1 : 0;
    }
}
