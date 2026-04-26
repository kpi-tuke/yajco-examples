package yajco.example.expression;

import yajco.example.expression.model.Expression;
import yajco.example.parser.ExpressionParser;

public class Main {
    public static void main(String[] args) {
        String input = "(1+6/2)*30";
        try {
            Expression expression = new ExpressionParser().parse(input);
            System.out.println("Result for '" + input + "' is: " + expression.eval());
        } catch (yajco.example.parser.ParseException e) {
            System.err.println(e.getMessage());
        }
    }
}
