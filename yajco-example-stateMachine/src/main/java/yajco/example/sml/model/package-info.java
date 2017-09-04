@Parser(className = "yajco.exemple.sml.parser.StateMachineParser",
mainNode = "StateMachine",
tokens = {
    @TokenDef(name = "ID", regexp = "[a-zA-Z][a-zA-Z0-9]*")
},
skips = {
    @Skip("#.*\\n"), //comment
    @Skip(" "),
    @Skip("\\t"),
    @Skip("\\n"),
    @Skip("\\r")
})
package yajco.example.sml.model;

import yajco.annotation.config.Parser;
import yajco.annotation.config.Skip;
import yajco.annotation.config.TokenDef;
