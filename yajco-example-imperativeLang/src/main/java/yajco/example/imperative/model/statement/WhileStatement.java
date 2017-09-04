package yajco.example.imperative.model.statement;

import yajco.annotation.After;
import yajco.annotation.Before;
import yajco.example.imperative.model.expression.Expression;

public class WhileStatement implements Statement {
    private final Expression expression;
    
    private final Statement statement;
    
    public WhileStatement(
            @Before({"WHILE", "LPAR"}) @After("RPAR") Expression expression,
            Statement statement
            ) {
        this.expression = expression;
        this.statement = statement;
    }

    @Override
    public void execute() {
        while (getExpression().eval() != 0) {
            getStatement().execute();
        }
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
