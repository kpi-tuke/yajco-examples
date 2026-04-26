package yajco.example.desk;

import yajco.example.desk.model.Program;
import yajco.example.desk.parser.DeskParser;

public class Main {
    public static void main(String[] args) throws Exception {
        String expr = "print x + y + 3 + 2 where x = 1, y = 2";
        //String expr = "print (52)";

        Program program = new DeskParser().parse(expr);

        System.out.println("--------------------- PROGRAM RESULT ---------------------");
        System.out.println(program.code());

        System.out.println("---------------------- AST OUTPUT ------------------------");
        System.out.println(program);

        System.out.println();
    }
}
