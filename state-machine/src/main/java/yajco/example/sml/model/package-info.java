@Language(
    name = "state-machine",
    description = "A state machine definition language",
    version = "1.0.0",
    fileExtensions = {".sml"},
    lineComment = "#"
)
@Parser(className = "yajco.example.sml.parser.StateMachineParser",
    mainNode = "StateMachine",
    tokens = {
        @TokenDef(name = "ID", regexp = "[a-zA-Z][a-zA-Z0-9]*")
    },
    skips = {
        @Skip(" "),
        @Skip("\\t"),
        @Skip("\\n"),
        @Skip("\\r")
    })
package yajco.example.sml.model;

import yajco.annotation.config.Language;
import yajco.annotation.config.Parser;
import yajco.annotation.config.Skip;
import yajco.annotation.config.TokenDef;
