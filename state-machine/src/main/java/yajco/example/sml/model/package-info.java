@Parser(className = "yajco.example.sml.parser.StateMachineParser",
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
    },
    options = {
        @Option(name = "yajco.generateTools", value = "ir"),
        @Option(name = "yajco.ir.file", value = "state-machine.ir.json"),
        @Option(name = "yajco.ir.languageName", value = "state-machine"),
        @Option(name = "yajco.ir.fileExtensions", value = ".sml")
    })
package yajco.example.sml.model;

import yajco.annotation.config.Option;
import yajco.annotation.config.Parser;
import yajco.annotation.config.Skip;
import yajco.annotation.config.TokenDef;
