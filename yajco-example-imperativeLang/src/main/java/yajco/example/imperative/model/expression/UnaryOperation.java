package yajco.example.imperative.model.expression;

public abstract class UnaryOperation implements Expression {
    private final Expression expression;

    public UnaryOperation(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }
}
