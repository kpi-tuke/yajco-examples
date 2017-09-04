/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yajco.example.json.model;

import yajco.annotation.*;

/**
 *
 * @author Šimonko
 */
public class Members {

    private String string;
    private Node value;

    public Members(@Token("VALUE") String string,
            @Before("DVOJBODKA") Node value) {

        this.string = string;
        this.value = value;

        System.out.println("String: " + string);

    }

    /**
     * @return the string
     */
    public String getString() {
        return string;
    }

    /**
     * @return the value
     */
    public Node getValue() {
        return value;
    }
}
