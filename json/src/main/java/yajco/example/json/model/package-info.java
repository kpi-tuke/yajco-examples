@Parser(className = "yajco.example.json.parser.JsonParser",
    mainNode = "JsonValue",
    tokens = {
        @TokenDef(name = "STRING", regexp = "\"([^\"]*)\""),
        @TokenDef(name = "NUMBER", regexp = "([-]?[0-9]+(\\.[0-9]+)?([eE][+-][0-9]+)?)"),
        @TokenDef(name = "BOOLEAN", regexp = "(true)|(false)"),
    },
    skips = {
        @Skip(" "),
        @Skip("\\t"),
        @Skip("\\n"),
        @Skip("\\r")
    },
    options = {
        @Option(name = "yajco.generateTools", value = "ir"),
        @Option(name = "yajco.ir.file", value = "json.ir.json"),
        @Option(name = "yajco.ir.languageName", value = "json"),
        @Option(name = "yajco.ir.fileExtensions", value = ".json")
    })
package yajco.example.json.model;

import yajco.annotation.config.Option;
import yajco.annotation.config.Parser;
import yajco.annotation.config.Skip;
import yajco.annotation.config.TokenDef;
