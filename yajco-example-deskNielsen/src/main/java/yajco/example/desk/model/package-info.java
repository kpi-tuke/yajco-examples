@Parser(
    className = "yajco.example.desk.parser.DeskParser",
    mainNode = "Program",
    tokens = {
        @TokenDef(name = "NAME", regexp = "[a-zA-Z]+"),
        @TokenDef(name = "VALUE", regexp = "[0-9]+")
    },
    skips = {
        @Skip("[ ]"),
        @Skip("[\\t]"),
        @Skip("[\\n]"),
        @Skip("[\\r]")
    },
    options = {
        @Option(name = "yajco.generateTools", value="all")
    }
)
package yajco.example.desk.model;

import yajco.annotation.config.Option;
import yajco.annotation.config.Parser;
import yajco.annotation.config.Skip;
import yajco.annotation.config.TokenDef;
