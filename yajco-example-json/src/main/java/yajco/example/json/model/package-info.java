@Parser(className = "yajco.example.json.parser.JsonParser",
mainNode = "JsonFile",
tokens = {
    @TokenDef(name = "KONOBJ", regexp = "[}]"),
    @TokenDef(name = "ZACOBJ", regexp = "[{]"),
//    @TokenDef(name = "STRING", regexp = "\"([a-zA-Z_][a-zA-Z]*)\""),
    @TokenDef(name = "VALUE", regexp = "\"([^\"]*)\""),
    @TokenDef(name = "CISLO", regexp = "([0-9]*)"),
    @TokenDef(name = "BOOLEAN", regexp = "(true)|(false)"),
    @TokenDef(name = "NULL", regexp = "null"),
    @TokenDef(name = "KONPOLE", regexp = "\\]"),
    @TokenDef(name = "ZACPOLE", regexp = "\\["),
    @TokenDef(name = "DVOJBODKA", regexp = ":")
},
skips = {
    @Skip(" "),
    @Skip("\\t"),
    @Skip("\\n"),
    @Skip("\\r")
})
package yajco.example.json.model;

import yajco.annotation.config.Parser;
import yajco.annotation.config.Skip;
import yajco.annotation.config.TokenDef;
