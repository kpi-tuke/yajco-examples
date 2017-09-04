package yajco.example.desk;

import java.io.PrintWriter;
import yajco.example.desk.model.Program;
import yajco.example.desk.model.printer.Printer;
import yajco.example.desk.parser.DeskParser;

public class Main {
    public static void main(String[] args) throws Exception {
        String expr = "print x + y + 3 + 2 where x = 1, y = 2";
        //String expr = "print (52)";

        Program program ;
        program = new DeskParser().parse(expr);
        System.out.println("--------------------- PROGRAM RESULT ---------------------");
        System.out.println(program.code());

        System.out.println("--------------------- PRINTER OUTPUT ---------------------");
        Printer printer = new Printer();
        printer.print(program, new PrintWriter(System.out));

        System.out.println("");


    }
}
