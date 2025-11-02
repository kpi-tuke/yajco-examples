package yajco.example.imperative.machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Machine {
    private static final Machine instance = new Machine();

    private final Stack<Map<String, Long>> variableStack = new Stack<>();

    private Map<String, Long> variables;

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private Machine() {
        beginFunction();
    }

    public static Machine getInstance() {
        return instance;
    }

    public void beginFunction() {
        variables = new HashMap<>();
        variableStack.push(variables);
    }

    public void endFunction() {
        variableStack.pop();
        variables = variableStack.peek();
    }

    public long getValue(String identifier) {
        return variables.get(identifier);
    }

    public void setValue(String identifier, long value) {
        variables.put(identifier, value);
    }

    public void write(long value) {
        System.out.println(value);
    }

    public void read(String identifier) {
        try {
            String line = reader.readLine();
            setValue(identifier, Long.parseLong(line));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public String toString() {
        return variables.toString();
    }
}
