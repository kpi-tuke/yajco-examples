package yajco.example.imperative.model.expression.assignment;

import yajco.example.imperative.machine.Machine;
import yajco.example.imperative.model.expression.BinaryOperation;
import yajco.example.imperative.model.expression.Expression;
import yajco.example.imperative.model.expression.Variable;

public abstract class AssignmentGeneric extends BinaryOperation {
    public AssignmentGeneric(Expression expression1, Expression expression2) {
        super(expression1, expression2);
    }

    @Override
    public long eval() {
        long value = getExpression2().eval();
        String ident = ((Variable) getExpression1()).getIdent();
        value = eval(Machine.getInstance().getValue(ident), value);
        Machine.getInstance().setValue(ident, value);
        return value;
    }

    protected abstract long eval(long value1, long value2);
}
