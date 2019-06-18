/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uptc.logic;

import java.util.ArrayList;

/**
 *
 * @author javierpardo
 */
public class MngEdge {
    private ArrayList<Edge> edges = new ArrayList<>();
    
    public void addEdge(String name, int value, String vertex1, String vertex2){
        edges.add(new Edge(name, value, vertex1, vertex2));
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }
}
