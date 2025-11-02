package yajco.example.imperative.model.expression.conditional;

import yajco.annotation.Before;
import yajco.annotation.Operator;
import yajco.example.imperative.model.expression.Expression;
import yajco.example.imperative.model.expression.UnaryOperation;

public final class Not extends UnaryOperation {
    @Operator(priority = 13)
    public Not(@Before("EXCL") Expression expression) {
        super(expression);
    }

    @Override
    public long eval() {
        return getExpression().eval() == 0 ? 1 : 0;
    }
}
