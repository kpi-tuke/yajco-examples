package yajco.example.extMathExpr.model;

import yajco.annotation.Before;
import yajco.annotation.Operator;

public final class Add extends BinaryOperation {
    @Operator(priority = 1)
    public Add(Expression expression1, @Before("PLUS") Expression expression2) {
        super(expression1, expression2);
    }

    public long eval() {
        return getExpression1().eval() + getExpression2().eval();
    }
}
