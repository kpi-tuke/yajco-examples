package yajco.example.extMathExpr;

import java.io.InputStream;
import java.io.InputStreamReader;

import yajco.example.extMathExpr.model.Expression;
import yajco.example.extMathExpr.parser.ExpressionParser;

public class Main {
    public static void main(String[] args) throws Exception {
        InputStream in = Main.class.getResourceAsStream("/input.expr");
        if (in == null) throw new RuntimeException("input.expr not found");

        Expression expression = new ExpressionParser().parse(new InputStreamReader(in));

        System.out.println("Result: " + expression.eval());
        System.out.println("\nAST output:");
        System.out.println(expression);
        System.out.println();
    }
}
