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
public class Number extends Node {

    private String cislo;

    public Number(@Token("CISLO") String cislo){

        this.cislo = cislo;

        System.out.println("Cislo: " + cislo);

    }

    /**
     * @return the cislo
     */
    public String getCislo() {
        return cislo;
    }

}
