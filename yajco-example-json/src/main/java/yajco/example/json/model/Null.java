/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package yajco.example.json.model;

import yajco.annotation.Token;

/**
 *
 * @author Šimonko
 */
public class Null extends Node {

    private String nula;

    public Null(@Token("NULL") String nula){


        this.nula = nula;

        System.out.println(nula);
    }
    /**
     * @return the nula
     */
    public String getNula() {
        return nula;
    }

}
