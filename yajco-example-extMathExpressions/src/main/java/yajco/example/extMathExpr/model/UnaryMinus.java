package yajco.example.extMathExpr.model;

import yajco.annotation.Before;
import yajco.annotation.Operator;

public final class UnaryMinus extends UnaryOperation {
    @Operator(priority = 3)
    public UnaryMinus(@Before("MINUS") Expression expression) {
        super(expression);
    }

    @Override
    public long eval() {
        return -getExpression().eval();
    }
}
