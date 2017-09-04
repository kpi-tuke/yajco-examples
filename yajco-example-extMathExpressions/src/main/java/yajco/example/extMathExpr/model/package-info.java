@Parser(
    className = "yajco.example.extMathExpr.parser.ExpressionParser",
    mainNode = "Expression",
    tokens = {
        @TokenDef(name = "PLUS", regexp = "\\+"),
        @TokenDef(name = "MINUS", regexp = "-"),
        @TokenDef(name = "STAR", regexp = "\\*"),
        @TokenDef(name = "SLASH", regexp = "/"),
        @TokenDef(name = "PERC", regexp = "%"),
        @TokenDef(name = "EXCL", regexp = "!"),
        @TokenDef(name = "POWER", regexp = "\\^"),
        @TokenDef(name = "TILDE", regexp = "~"),        
        @TokenDef(name = "QUESTION", regexp = "\\?"),
        @TokenDef(name = "COLON", regexp = ":"),
        @TokenDef(name = "EQ", regexp = "=="),
        @TokenDef(name = "NEQ", regexp = "!="),
        @TokenDef(name = "ASS", regexp = "="),
        @TokenDef(name = "LPAR", regexp = "[(]"),
        @TokenDef(name = "RPAR", regexp = "[)]"),
        @TokenDef(name = "VALUE", regexp = "([0-9]+)")
    },
    skips = {
        @Skip(" "), 
        @Skip("\\t"), 
        @Skip("\\n"), 
        @Skip("\\r")
    },
    options= {@Option(name="yajco.generateTools",value="all")}
)
package yajco.example.extMathExpr.model;

import yajco.annotation.config.Option;
import yajco.annotation.config.Parser;
import yajco.annotation.config.TokenDef;
import yajco.annotation.config.Skip;
