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
public class MngVertex {
    private ArrayList<Vertex> vertices= new ArrayList<>();
    private ArrayList<Integer> distances = new ArrayList<>();
    private int posLess = 0;
    
    public boolean addVertex(String name, int distance, int x, int y, String vertexUnon){
        for(Vertex vertex: vertices){
            if(vertex.getX() == x && vertex.getY() == y){
                return false;
            }
        }
        vertices.add(new Vertex(name, distance, x, y, vertexUnon));
        return true;
    }
    
    public Vertex findNearest(int x, int y){
        distances.clear();
        for (int i = 0; i < vertices.size(); i++) {
            int distance = (int) Math.sqrt(Math.pow(x-vertices.get(i).getX(), 2)+Math.pow(y-vertices.get(i).getY(), 2))/20;
            distances.add(distance);
        }
        int less = distances.get(0);
        for (int i = 0; i < distances.size(); i++) {
            if(distances.get(i)<=less){
                posLess = i;
                less = distances.get(i);
            }
        }
        return vertices.get(posLess);
    }

    public ArrayList<Vertex> getVertexs() {
        return vertices;
    }

    public ArrayList<Integer> getDistances() {
        return distances;
    }

    public int getPosLess() {
        return posLess;
    }
    
    public boolean validateAdjacency(String vr1){
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 1; j < vertices.size(); j++) {
                if(vertices.get(i).getName().equals(vertices.get(j).getVertexUnion())){
                    return true;
                }
            }
        }
        return false;
    }
}
