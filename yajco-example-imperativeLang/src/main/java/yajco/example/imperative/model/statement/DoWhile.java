package yajco.example.imperative.model.statement;

import yajco.annotation.After;
import yajco.annotation.Before;
import yajco.example.imperative.model.expression.Expression;

public class DoWhile implements Statement {
    private final Expression expression;

    private final Statement statement;

    public DoWhile(
            @Before("DO") Statement statement,
            @Before({"WHILE", "LPAR"}) @After({"RPAR", "SEMICOLON"}) Expression expression
            ) {
        this.expression = expression;
        this.statement = statement;
    }

    @Override
    public void execute() {
        do {
            getStatement().execute();
        } while (getExpression().eval() != 0);
    }

    /**
     * @return the expression
     */
    public Expression getExpression() {
        return expression;
    }

    /**
     * @return the statement
     */
    public Statement getStatement() {
        return statement;
    }
}
