package yajco.example.imperative;

import yajco.example.imperative.machine.Machine;
import yajco.example.imperative.model.Program;
import yajco.example.imperative.parser.Parser;

import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        InputStream in = Main.class.getResourceAsStream("/program");
        if (in == null) throw new RuntimeException("/program not found");

        Program program = new Parser().parse(new InputStreamReader(in));
        program.execute();

        System.out.println(Machine.getInstance());
    }
}
