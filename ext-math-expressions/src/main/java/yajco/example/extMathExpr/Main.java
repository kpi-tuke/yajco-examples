package yajco.example.extMathExpr;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import yajco.example.extMathExpr.model.Expression;
import yajco.example.extMathExpr.model.printer.Printer;
import yajco.example.extMathExpr.parser.ExpressionParser;

public class Main {
    public static void main(String[] args) throws Exception {
        InputStream in = Main.class.getResourceAsStream("/input.txt");
        if (in == null) throw new RuntimeException("input.txt not found");

        Expression expression = new ExpressionParser().parse(new InputStreamReader(in));

        System.out.println("Result: " + expression.eval());
        System.out.println("\nPrinter output:");
        new Printer().print(expression, new PrintWriter(System.out, true));
        System.out.println();
    }
}
