/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package yajco.example.json.model;

import java.util.List;

/**
 *
 * @author Šimonko
 */
public abstract class Node {
    protected List<Node> nodeList;

    /**
     * @return the nodeList
     */
    public List<Node> getNodeList() {
        return nodeList;
    }
}
