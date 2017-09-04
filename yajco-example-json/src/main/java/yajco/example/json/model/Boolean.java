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
public class Boolean extends Node {

    private boolean bo;

    public Boolean(@Token("BOOLEAN") boolean bo){

        this.bo = bo;

        System.out.println("Booleanovska hodnota: " + bo);

    }

    /**
     * @return the bo
     */
    public boolean isBo() {
        return bo;
    }

}
