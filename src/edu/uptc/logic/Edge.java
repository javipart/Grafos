/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uptc.logic;

/**
 *
 * @author javierpardo
 */
public class Edge {
    private String name;
    private int value;
    private String vertex1;
    private String vertex2;

    public Edge(String name, int value, String vertex1, String vertex2) {
        this.name = name;
        this.value = value;
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getVertex1() {
        return vertex1;
    }

    public void setVertex1(String vertex1) {
        this.vertex1 = vertex1;
    }

    public String getVertex2() {
        return vertex2;
    }

    public void setVertex2(String vertex2) {
        this.vertex2 = vertex2;
    }

    @Override
    public String toString() {
        return "Edge{" + "name=" + name + ", value=" + value + ", vertex1=" + vertex1 + ", vertex2=" + vertex2 + '}';
    }
    
    
    
}
