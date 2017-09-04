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
public class NodeString extends Node {

    private String retazec;


    public NodeString (@Token("VALUE") String retazec) {

        this.retazec = retazec;

        System.out.println("Hodnota retazca/value: " + retazec);

    }

    /**
     * @return the retazec
     */
    public String getRetazec() {
        return retazec;
    }
}
