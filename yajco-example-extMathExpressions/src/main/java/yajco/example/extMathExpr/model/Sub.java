package yajco.example.extMathExpr.model;

import yajco.annotation.Before;
import yajco.annotation.Operator;

public final class Sub extends BinaryOperation {
    @Operator(priority = 1)
    public Sub(Expression expression1, @Before("MINUS") Expression expression2) {
        super(expression1, expression2);
    }

    public long eval() {
        return getExpression1().eval() - getExpression2().eval();
    }
}
