package yajco.example.sml;

import java.io.InputStream;
import java.io.InputStreamReader;

import yajco.example.sml.parser.StateMachineParser;
import yajco.example.sml.model.StateMachine;

public class Main {
    public static void main(String[] args) throws Exception {
        InputStream in = Main.class.getResourceAsStream("/machine.sml");
        if (in == null) throw new RuntimeException("machine.sml not found");

        StateMachine machine = new StateMachineParser().parse(new InputStreamReader(in));

        System.out.println("OUTPUT:");
        System.out.println(machine);
    }
}
