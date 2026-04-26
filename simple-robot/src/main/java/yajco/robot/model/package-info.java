@Language(
    name = "simple-robot",
    description = "A simple robot programming language",
    version = "1.0.0",
    fileExtensions = {".robot"},
    lineComment = "//"
)
@Parser(mainNode = "yajco.robot.model.Robot", //class of root concept
    className = "yajco.robot.model.parser.Parser", //class name of generated parser
    skips = {
        @Skip("\\s") //regular expression for whitespace
    }
)
package yajco.robot.model;

import yajco.annotation.config.Language;
import yajco.annotation.config.Parser;
import yajco.annotation.config.Skip;
