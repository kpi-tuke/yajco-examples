package yajco.example.imperative.model.expression;

import yajco.annotation.Parentheses;

@Parentheses(left="LPAR",right="RPAR")
public interface Expression {
    long eval();
}
