package yajco.example.extMathExpr.model;

public abstract class UnaryOperation extends Expression {
    private final Expression expression;

    public UnaryOperation(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }
}
