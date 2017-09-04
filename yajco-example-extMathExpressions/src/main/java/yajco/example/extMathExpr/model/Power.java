package yajco.example.extMathExpr.model;

import yajco.annotation.Before;
import yajco.annotation.Operator;

public final class Power extends BinaryOperation {
    @Operator(priority = 2)
    public Power(Expression expression1, @Before("POWER") Expression expression2) {
        super(expression1, expression2);
    }

    @Override
    public long eval() {
        return (long) Math.pow(getExpression1().eval(), getExpression2().eval());
    }
}
