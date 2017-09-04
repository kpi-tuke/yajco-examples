@Parser(
    className = "yajco.example.parser.ExpressionParser",
    mainNode = "Expression",
    tokens = {
        @TokenDef(name = "PLUS", regexp = "[+]"),
        @TokenDef(name = "MINUS", regexp = "[-]"),
        @TokenDef(name = "STAR", regexp = "[*]"),
        @TokenDef(name = "SLASH", regexp = "[/]"),
        @TokenDef(name = "POW", regexp = "[^]"),
        @TokenDef(name = "VALUE", regexp = "([0-9]+)")
    },
    skips = {
        @Skip(" "),
        @Skip("\\t"),
        @Skip("\\n"),
        @Skip("\\r")
    }
)
package yajco.example.expression.model;

import yajco.annotation.config.Parser;
import yajco.annotation.config.TokenDef;
import yajco.annotation.config.Skip;
