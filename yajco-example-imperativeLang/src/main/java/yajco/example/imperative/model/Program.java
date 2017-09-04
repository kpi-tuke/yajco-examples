package yajco.example.imperative.model;

import yajco.example.imperative.model.function.Function;
import yajco.example.imperative.model.statement.Block;

public class Program {
    private final Function[] functions;

    private final Block main;

    public Program(Function[] functions, Block main) {
        this.functions = functions;
        this.main = main;
    }

    public void execute() {
        getMain().execute();
    }

    /**
     * @return the functions
     */
    public Function[] getFunctions() {
        return functions;
    }

    /**
     * @return the main
     */
    public Block getMain() {
        return main;
    }
}
