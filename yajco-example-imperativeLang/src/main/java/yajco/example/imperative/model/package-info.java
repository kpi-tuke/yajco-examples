@Parser(
    className = "yajco.example.imperative.parser.Parser",
    mainNode = "yajco.example.imperative.model.Program",
    tokens = {
        @TokenDef(name = "RETURN", regexp = "return"),
        
        @TokenDef(name = "IF", regexp = "if"),
        @TokenDef(name = "ELSE", regexp = "else"),
        @TokenDef(name = "WHILE", regexp = "while"),
        @TokenDef(name = "DO", regexp = "do"),
        @TokenDef(name = "FOR", regexp = "for"),
        @TokenDef(name = "WRITE", regexp = "write"),
        @TokenDef(name = "READ", regexp = "read"),

        @TokenDef(name = "PLUSPLUS", regexp = "\\+\\+"),
        @TokenDef(name = "MINUSMINUS", regexp = "--"),
        
        @TokenDef(name = "PLUS", regexp = "\\+"),
        @TokenDef(name = "MINUS", regexp = "-"),
        @TokenDef(name = "STAR", regexp = "\\*"),
        @TokenDef(name = "SLASH", regexp = "/"),
        @TokenDef(name = "PERC", regexp = "%"),

        @TokenDef(name = "EQ", regexp = "=="),
        @TokenDef(name = "NEQ", regexp = "!="),
        @TokenDef(name = "LTE", regexp = "<="),
        @TokenDef(name = "LT", regexp = "<"),
        @TokenDef(name = "GTE", regexp = ">="),
        @TokenDef(name = "GT", regexp = ">"),

        @TokenDef(name = "AND", regexp = "&&"),
        @TokenDef(name = "OR", regexp = "||"),
        @TokenDef(name = "EXCL", regexp = "!"),
        @TokenDef(name = "QUESTION", regexp = "\\?"),

        @TokenDef(name = "COMMA", regexp = ","),
        @TokenDef(name = "COLON", regexp = ":"),
        @TokenDef(name = "SEMICOLON", regexp = ";"),
        
        @TokenDef(name = "ASSIGN", regexp = "="),
        @TokenDef(name = "ASSIGNADD", regexp = "\\+="),
        @TokenDef(name = "ASSIGNSUB", regexp = "-="),
        @TokenDef(name = "ASSIGNMUL", regexp = "\\*="),
        @TokenDef(name = "ASSIGNDIV", regexp = "/="),
        @TokenDef(name = "ASSIGNMOD", regexp = "%="),

        @TokenDef(name = "LPAR", regexp = "[(]"),
        @TokenDef(name = "RPAR", regexp = "[)]"),
        @TokenDef(name = "LBR", regexp = "\\{"),
        @TokenDef(name = "RBR", regexp = "\\}"),
        
        @TokenDef(name = "IDENT", regexp = "[a-zA-Z]+"),
        @TokenDef(name = "VALUE", regexp = "[0-9]+")
    },
    skips = {
        @Skip(" "), 
        @Skip("\\t"), 
        @Skip("\\n"), 
        @Skip("\\r")
    }
)
package yajco.example.imperative.model;

import yajco.annotation.config.Parser;
import yajco.annotation.config.Skip;
import yajco.annotation.config.TokenDef;

