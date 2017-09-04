package mylang;

import yajco.annotation.*;
import yajco.annotation.config.*;

@Parser(tokens = @TokenDef(name = "ident", regexp = "[a-z]+"))
public class SimpleIdentifier {

    private String identifier;

    @Before("id")
    public SimpleIdentifier(String ident) {
        identifier = ident;
    }

    public String getIdentifier() {
        return identifier;
    }
}