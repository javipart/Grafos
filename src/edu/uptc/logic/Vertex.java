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
public class Vertex {
    private String name;
    private int distance;
    private int x;
    private int y;
    private String vertexUnion;

    public Vertex(String name, int distance, int x, int y, String vertexUnion) {
        this.name = name;
        this.distance = distance;
        this.x = x;
        this.y = y;
        this.vertexUnion = vertexUnion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getVertexUnion() {
        return vertexUnion;
    }

    public void setVertexUnion(String vertexUnion) {
        this.vertexUnion = vertexUnion;
    }
    
    
}
