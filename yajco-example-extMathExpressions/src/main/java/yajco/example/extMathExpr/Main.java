package yajco.example.extMathExpr;

import java.io.FileReader;
import java.io.PrintWriter;

import yajco.example.extMathExpr.model.Expression;
import yajco.example.extMathExpr.model.printer.Printer;
import yajco.example.extMathExpr.parser.ExpressionParser;

public class Main {
    public static void main(String[] args) throws Exception {
        Expression expression = new ExpressionParser().parse(new FileReader("input.txt"));
        System.out.println("Result: "+expression.eval());

        Printer printer = new Printer();
        System.out.println("\nPrinter output:");
        printer.print(expression, new PrintWriter(System.out));
    }
}
