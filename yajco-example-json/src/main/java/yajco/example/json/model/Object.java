/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yajco.example.json.model;

import java.util.List;
import yajco.annotation.*;

/**
 *
 * @author Šimonko
 */
public class Object extends Node {

   
    private List<Members> men;


    /*
     * 
     */
    @Before("ZACOBJ")
    @After("KONOBJ")
    public Object() {
        System.out.println("Zaciatok objektu");
        System.out.println("Koniec objektu______prazdny object");
    }

    /*
     *
     */
    @Before("ZACOBJ")
    @After("KONOBJ")
    public Object(@Separator(",") List<Members> men) {
        this.men = men;
        System.out.println("Zaciatok objektu");
        System.out.println("Koniec objektu");
    }



    /**
     * @return the men
     */
    public List<Members> getMen() {
        return men;
    }

    @Override
    public List<Node> getNodeList() {
        return super.getNodeList();
    }
}
