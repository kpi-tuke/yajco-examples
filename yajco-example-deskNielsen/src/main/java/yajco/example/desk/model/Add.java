package yajco.example.desk.model;

import yajco.annotation.Before;
import yajco.annotation.Operator;

public final class Add extends Expression {
    private final Expression expression1;

    private final Expression expression2;

    @Operator(priority = 1)
    public Add(Expression expression1, @Before("+") Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public String code() {
        return getExpression2().code() + getExpression1().code() + "ADD" + "\n";
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
