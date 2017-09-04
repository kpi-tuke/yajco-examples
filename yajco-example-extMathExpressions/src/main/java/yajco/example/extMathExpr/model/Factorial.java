package yajco.example.extMathExpr.model;

import yajco.annotation.After;
import yajco.annotation.Operator;

public final class Factorial extends UnaryOperation {

    @Operator(priority = 4)
    public Factorial(@After("EXCL") Expression expression) {
        super(expression);
    }

    @Override
    public long eval() {
        long value = getExpression().eval();
        if(value < 0) {
            throw new RuntimeException("Factorial of negative number is not defined");
        }
        long factorial = 1;
        for(long i = 2; i <= value; i++) {
            factorial *= i;
        }

        return factorial;
    }
}
