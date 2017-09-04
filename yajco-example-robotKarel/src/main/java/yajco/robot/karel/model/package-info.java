//Karel programming language (subset)
//http://mormegil.wz.cz/prog/karel/prog_doc.htm
@Parser(
    className = "yajco.robot.karel.parser.Parser",
    mainNode = "yajco.robot.karel.model.Program",
    tokens = {
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
package yajco.robot.karel.model;

import yajco.annotation.config.Parser;
import yajco.annotation.config.TokenDef;
import yajco.annotation.config.Skip;
