package yajco.example.imperative.model.statement;

import yajco.annotation.After;
import yajco.annotation.Before;
import yajco.example.imperative.model.expression.Expression;

public class Condition implements Statement {
    private final Expression expression;
    
    private final Statement trueStatement;
    
    private final Statement falseStatement;

    public Condition(
            @Before({"IF", "LPAR"}) @After("RPAR") Expression expression, 
            Statement trueStatement, 
            @Before("ELSE") Statement falseStatement) {
        this.expression = expression;
        this.trueStatement = trueStatement;
        this.falseStatement = falseStatement;
    }

    public Condition(
            @Before({"IF", "LPAR"}) @After("RPAR") Expression expression,
            Statement trueStatement) {
        this.expression = expression;
        this.trueStatement = trueStatement;
        this.falseStatement = null;
    }

    @Override
    public void execute() {
        if(getExpression().eval() != 0) {
            getTrueStatement().execute();
        } else if(getFalseStatement() != null) {
            getFalseStatement().execute();
        }     
    }

    /**
     * @return the expression
     */
    public Expression getExpression() {
        return expression;
    }

    /**
     * @return the trueStatement
     */
    public Statement getTrueStatement() {
        return trueStatement;
    }

    /**
     * @return the falseStatement
     */
    public Statement getFalseStatement() {
        return falseStatement;
    }
}
