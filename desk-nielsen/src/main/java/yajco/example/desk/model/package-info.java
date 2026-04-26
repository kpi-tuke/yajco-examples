@Language(
    name = "desk",
    description = "A Desk (Nielsen) calculator language",
    version = "1.0.0",
    fileExtensions = {".desk"}
)
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
    }
)
package yajco.example.desk.model;

import yajco.annotation.config.Language;
import yajco.annotation.config.Parser;
import yajco.annotation.config.Skip;
import yajco.annotation.config.TokenDef;
