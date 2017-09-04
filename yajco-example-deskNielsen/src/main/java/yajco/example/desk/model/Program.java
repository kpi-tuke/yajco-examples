package yajco.example.desk.model;

import yajco.annotation.Before;
import yajco.annotation.Range;
import yajco.annotation.Separator;

public class Program {
    private final Expression expression;

    private final Constant[] constants;

    public Program(
            @Before("print")
                    Expression expression,
            @Before("where")
            @Range(minOccurs = 1)
            @Separator(",")
                    Constant[] constants) {
        this.expression = expression;
        this.constants = constants;
    }
    
    public Program(
            @Before("print")
                    Expression expression) {
        this.expression = expression;
        this.constants = null;
    }

    public String code() {
        return getExpression().code();
    }

    /**
     * @return the expression
     */
    public Expression getExpression() {
        return expression;
    }

    /**
     * @return the constants
     */
    public Constant[] getConstants() {
        return constants;
    }
}
