package yajco.example.imperative.model.function;

import yajco.example.imperative.machine.Machine;
import yajco.example.imperative.machine.MachineException;
import yajco.example.imperative.machine.ReturnException;
import yajco.example.imperative.model.expression.*;
import yajco.annotation.After;
import yajco.annotation.Before;
import yajco.annotation.Separator;
import yajco.annotation.reference.References;

public class FunctionCall implements Expression {
    private Function function;

    private final Expression[] expressions;

    public FunctionCall(
            @References(Function.class) String ident,
            @Before("LPAR") @After("RPAR")
            @Separator("COMMA") Expression[] expressions) {
        this.expressions = expressions;
    }

    public long eval() {
        Machine machine = Machine.getInstance();
        try {
            Parameter[] parameters = getFunction().getParameters();
            long[] parametersValues = new long[getExpressions().length];
            for (int i = 0; i < parametersValues.length; i++) {
                parametersValues[i] = getExpressions()[i].eval();
            }
            machine.beginFunction();
            for (int i = 0; i < parametersValues.length; i++) {
                machine.setValue(parameters[i].getName(), parametersValues[i]);
            }
            getFunction().execute();
            throw new MachineException("Function should return a value");
        } catch (ReturnException ex) {
            return ex.getValue();
        } finally {
            machine.endFunction();
        }
    }

    /**
     * @return the function
     */
    public Function getFunction() {
        return function;
    }

    /**
     * @return the expressions
     */
    public Expression[] getExpressions() {
        return expressions;
    }
}
