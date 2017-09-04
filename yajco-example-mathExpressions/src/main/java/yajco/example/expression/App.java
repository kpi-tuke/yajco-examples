package yajco.example.expression;

import yajco.example.expression.model.Expression;
import yajco.example.parser.ExpressionParser;

public class App {

    public static void main(String[] args) {
        String input = "(1+6/2)*30";
        try {
            ExpressionParser parser = new ExpressionParser();
            Expression expr = parser.parse(input);
            System.out.println("Result for '"+input+"' is: " + expr.eval());
        } catch (yajco.example.parser.ParseException ex) {
            System.err.println(ex.getMessage());;
        }
    }
}
