package yajco.example.expression.model;

import yajco.annotation.Before;
import yajco.annotation.Operator;
import yajco.model.pattern.impl.Associativity;

public final class Sub extends Expression {
    private final Expression expression1;

    private final Expression expression2;

    @Operator(priority = 1, associativity=Associativity.LEFT)
    public Sub(Expression expression1, @Before("MINUS") Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public long eval() {
        return getExpression1().eval() - getExpression2().eval();
    }

    /**
     * @return the expression1
     */
    public Expression getExpression1() {
        return expression1;
    }

    /**
     * @return the expression2
     */
    public Expression getExpression2() {
        return expression2;
    }
}
