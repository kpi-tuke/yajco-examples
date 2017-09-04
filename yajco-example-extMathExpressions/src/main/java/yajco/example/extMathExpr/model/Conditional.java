package yajco.example.extMathExpr.model;

import yajco.annotation.Before;
import yajco.annotation.Operator;
import yajco.model.pattern.impl.Associativity;

public final class Conditional extends Expression {
    private final Expression expression1;

    private final Expression expression2;

    private final Expression expression3;

    @Operator(priority = 0, associativity = Associativity.RIGHT)
    public Conditional(Expression expression1,
            @Before("QUESTION") Expression expression2, @Before("COLON") Expression expression3) {
        this.expression1 = expression1;
        this.expression2 = expression2;
        this.expression3 = expression3;
    }

    public long eval() {
        return getExpression1().eval() != 0 ? getExpression2().eval() : getExpression3().eval();
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

    /**
     * @return the expression3
     */
    public Expression getExpression3() {
        return expression3;
    }
}
