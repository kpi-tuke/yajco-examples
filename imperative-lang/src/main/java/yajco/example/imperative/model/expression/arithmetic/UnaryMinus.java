package yajco.example.imperative.model.expression.arithmetic;

import yajco.annotation.Before;
import yajco.annotation.Operator;
import yajco.example.imperative.model.expression.Expression;
import yajco.example.imperative.model.expression.UnaryOperation;

public final class UnaryMinus extends UnaryOperation {
    @Operator(priority = 13)
    public UnaryMinus(@Before("MINUS") Expression expression) {
        super(expression);
    }

    @Override
    public long eval() {
        return -getExpression().eval();
    }
}
