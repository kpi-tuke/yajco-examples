package yajco.example.extMathExpr.model;

import yajco.annotation.Before;
import yajco.annotation.Operator;

public final class UnaryPlus extends UnaryOperation {
    @Operator(priority = 3)
    public UnaryPlus(@Before("PLUS") Expression expression) {
        super(expression);
    }

    @Override
    public long eval() {
        return getExpression().eval();
    }
}
