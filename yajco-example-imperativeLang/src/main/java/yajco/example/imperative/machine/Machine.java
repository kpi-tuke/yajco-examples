package yajco.example.imperative.machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Machine {
    private static final Machine instance = new Machine();

    private Stack<Map<String, Long>> variableStack = new Stack<Map<String, Long>>();

    private Map<String, Long> variables;

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private Machine() {
        beginFunction();
    }

    public static Machine getInstance() {
        return instance;
    }

    public void beginFunction() {
        variables = new HashMap<String, Long>();
        variableStack.push(variables);
    }

    public void endFunction() {
        variableStack.pop();
        variables = variableStack.peek();
    }

    public long getValue(String ident) {
        return variables.get(ident);
    }

    public void setValue(String ident, long value) {
        variables.put(ident, value);
    }

    public void write(long value) {
        System.out.println(value);
    }

    public void read(String ident) {
        try {
            String line = reader.readLine();
            setValue(ident, Long.parseLong(line));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public String toString() {
        return variables.toString();
    }
}
