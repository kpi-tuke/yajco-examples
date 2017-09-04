package yajco.example.imperative.model.expression.arithmetic;

import yajco.annotation.Before;
import yajco.annotation.Operator;
import yajco.example.imperative.model.expression.Expression;
import yajco.example.imperative.model.expression.UnaryOperation;

public final class UnaryPlus extends UnaryOperation {
    @Operator(priority = 13)
    public UnaryPlus(@Before("PLUS") Expression expression) {
        super(expression);
    }

    @Override
    public long eval() {
        return getExpression().eval();
    }
}
