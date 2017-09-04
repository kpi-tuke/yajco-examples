package yajco.example.imperative.model.function;

import yajco.annotation.After;
import yajco.annotation.Before;
import yajco.example.imperative.machine.ReturnException;
import yajco.example.imperative.model.expression.Expression;
import yajco.example.imperative.model.statement.Statement;

public final class ReturnFunction implements Statement {
    private final Expression expression;

    public ReturnFunction(
            @Before("RETURN") @After("SEMICOLON") Expression expression) {
        this.expression = expression;
    }

    public void execute() {
        throw new ReturnException(getExpression().eval());
    }

    /**
     * @return the expression
     */
    public Expression getExpression() {
        return expression;
    }
}
