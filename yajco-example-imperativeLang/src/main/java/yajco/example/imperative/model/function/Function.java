package yajco.example.imperative.model.function;

import yajco.annotation.After;
import yajco.annotation.Before;
import yajco.annotation.Separator;
import yajco.annotation.reference.Identifier;
import yajco.example.imperative.model.statement.Block;

public class Function {
    @Identifier
    private final String name;

    private final Parameter[] parameters;
    
    private final Block body;

    public Function(
            String ident,
            @Before("LPAR") @After("RPAR")
            @Separator("COMMA") Parameter[] parameters,
            Block body) {                
        this.name = ident;
        this.parameters = parameters;
        this.body = body;
    }

    public String getName() {
        return name;
    }
    
    public Parameter[] getParameters() {
        return parameters;
    }
    
    public void execute() {
        getBody().execute();
    }

    /**
     * @return the body
     */
    public Block getBody() {
        return body;
    }

    public String getIdent() {
        return name;
    }
}
