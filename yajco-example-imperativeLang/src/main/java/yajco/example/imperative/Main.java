package yajco.example.imperative;

import yajco.example.imperative.machine.Machine;
import yajco.example.imperative.model.Program;
import yajco.example.imperative.parser.Parser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {
    public static void main(String[] args) throws Exception {
        Reader reader = new BufferedReader(new InputStreamReader(
                Main.class.getResourceAsStream("/program")));
        Program program = new Parser().parse(reader);

        program.execute();
        System.out.println(Machine.getInstance());
    }
}
