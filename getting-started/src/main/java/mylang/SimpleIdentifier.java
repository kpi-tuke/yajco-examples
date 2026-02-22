package mylang;

import yajco.annotation.*;
import yajco.annotation.config.*;

@Parser(
    tokens = @TokenDef(name = "ident", regexp = "[a-z]+"),
    options = {
        @Option(name = "yajco.generateTools", value = "ir"),
        @Option(name = "yajco.ir.file", value = "simple-identifier.ir.json"),
        @Option(name = "yajco.ir.languageName", value = "simple-identifier"),
        @Option(name = "yajco.ir.fileExtensions", value = ".sid")
    }
)
public class SimpleIdentifier {

    private final String identifier;

    @Before("id")
    public SimpleIdentifier(String ident) {
        identifier = ident;
    }

    public String getIdentifier() {
        return identifier;
    }
}
