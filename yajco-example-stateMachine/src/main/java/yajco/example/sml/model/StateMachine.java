package yajco.example.sml.model;

import java.util.Arrays;

public class StateMachine {
    private final Declaration[] declarations;

    public StateMachine(Declaration[] declarations) {
        this.declarations = declarations;
    }

    public Declaration[] getDeclarations() {
        return declarations;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Declaration declaration : declarations) {
            sb.append(declaration.toString());
            sb.append('\n');
        }
        return sb.toString();
    }
}
