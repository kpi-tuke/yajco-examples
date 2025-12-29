package yajco.example.extMathExpr.model;

import yajco.annotation.Parentheses;

@Parentheses
public abstract class Expression {
    public abstract long eval();
}
