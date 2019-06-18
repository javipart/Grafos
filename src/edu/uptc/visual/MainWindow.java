/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uptc.visual;

import edu.uptc.logic.Edge;
import edu.uptc.logic.MngEdge;
import edu.uptc.logic.MngVertex;
import edu.uptc.logic.Vertex;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author javierpardo
 */
public class MainWindow extends JFrame{
    private PanelPaint panelPaint;
    private PanelButton panelButton;
    private MngEdge mngEdge;
    private MngVertex mngVertex;
    private ViewTable viewTable;
    
    public MainWindow() {
        
        this.setTitle("GRAFOS");
        this.setSize(800, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        begin();
        
    }
    
    private void beginComponets() {
        mngVertex = new MngVertex();
        mngEdge = new MngEdge();
        panelButton = new PanelButton(this);
        panelPaint = new PanelPaint(this);
        viewTable = new ViewTable(this);
        
    }
    
    private void addComponets() {
        add(panelPaint, BorderLayout.CENTER);
        add(panelButton, BorderLayout.SOUTH);
    }

    private void begin() {
        beginComponets();
        addComponets();
    }

    public PanelButton getPanelButton() {
        return panelButton;
    }

    public PanelPaint getPanelPaint() {
        return panelPaint;
    }

    public MngEdge getEdge() {
        return mngEdge;
    }

    public MngVertex getVertex() {
        return mngVertex;
    }

    public ViewTable getViewTable() {
        return viewTable;
    }
    
    public void viewMatrix(){
        viewTable.viewMatrix();
        viewTable.setVisible(true);
    }
    
    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
    }

}
