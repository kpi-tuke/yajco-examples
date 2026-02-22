@Parser(mainNode = "yajco.robot.model.Robot", //class of root concept
    className = "yajco.robot.model.parser.Parser", //class name of generated parser
    skips = {
        @Skip("\\s") //regular expression for whitespace
    },
    options = {
        @Option(name = "yajco.generateTools", value = "ir"),
        @Option(name = "yajco.ir.file", value = "simple-robot.ir.json"),
        @Option(name = "yajco.ir.languageName", value = "simple-robot"),
        @Option(name = "yajco.ir.fileExtensions", value = ".robot")
    }
)
package yajco.robot.model;

import yajco.annotation.config.Option;
import yajco.annotation.config.Parser;
import yajco.annotation.config.Skip;
