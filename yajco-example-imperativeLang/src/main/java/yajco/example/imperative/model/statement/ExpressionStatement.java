package yajco.example.imperative.model.statement;

import yajco.annotation.After;
import yajco.example.imperative.model.expression.Expression;

public class ExpressionStatement implements Statement {
    private final Expression expression;

    public ExpressionStatement(@After("SEMICOLON") Expression expression) {
        this.expression = expression;
    }
    
    @Override
    public void execute() {
        getExpression().eval();
    }

    /**
     * @return the expression
     */
    public Expression getExpression() {
        return expression;
    }
}
