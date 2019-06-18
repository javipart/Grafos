/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uptc.visual;

import edu.uptc.logic.MngEdge;
import edu.uptc.logic.MngVertex;
import edu.uptc.logic.Vertex;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author javierpardo
 */
public class PanelPaint extends JPanel implements MouseListener {

    private MainWindow mainWindow;
    private Border border;
    private Image image;
    private Image imageTwrPr;
    private Graphics graphics;
    private MngVertex mngVertex;
    private MngEdge mngEdge;
    private int numEdge = 0;
    private int numVertex = 0;

    public PanelPaint(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setSize(800, 600);
        addMouseListener(this);
        beginComponents();
        addComponents();
    }

    private void beginComponents() {
        image = new ImageIcon(getClass().getResource("/img/tower.png")).getImage();
        imageTwrPr = new ImageIcon(getClass().getResource("/img/towerPr.png")).getImage();
        border = new TitledBorder(new EtchedBorder(), "Dibujo");
        mngVertex = mainWindow.getVertex();
        mngEdge = mainWindow.getEdge();
        setBorder(border);

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(imageTwrPr, 400 - 20, 300 - 20, 40, 40, null);
        mngVertex.addVertex("Central", 0, 400 - 20, 300 - 20, TOOL_TIP_TEXT_KEY);
        setOpaque(false);
        super.paint(g);
    }

    public void drawLine(int x, int y) {
        graphics = getGraphics();
        int distance = (int) Math.sqrt(Math.pow(x - 400, 2) + Math.pow(y - 300, 2)) / 20;
        if (mngVertex.getVertexs().size() == 0 && distance > 10) {
            if (mngVertex.addVertex("Ant" + numEdge, 0, x, y, "")) {
                graphics.drawImage(image, x - 15, y - 15, 30, 30, null);
                numVertex++;
            } else {
                JOptionPane.showMessageDialog(null, "No se puede agregar otra antena en la misma posicion");
            }

        } else if (distance <= 10) {
            numVertex++;
            numEdge++;
            String nameVertex = "Ant" + numVertex;
            String nameEdge = "a" + numEdge;
            if (mngVertex.addVertex(nameVertex, distance, x, y, "Central")) {
                mngEdge.addEdge(nameEdge, distance, "Central", nameVertex);
                graphics.drawLine(400, 300, x, y);
                graphics.drawImage(image, x - 15, y - 15, 30, 30, null);
                int xString = (400 + x) / 2;
                int yString = (300 + y) / 2;
                graphics.drawString("a" + numEdge + "=" + distance, xString, yString);
            } else {
                numVertex--;
                numEdge--;
                JOptionPane.showMessageDialog(null, "No se puede agregar otra antena en la misma posicion");
            }

        } else {
            Vertex vertex = mngVertex.findNearest(x, y);
            int xString = (vertex.getX() + x) / 2;
            int yString = (vertex.getY() + y) / 2;
            int distString = mngVertex.getDistances().get(mngVertex.getPosLess());
            if (distString <= 10) {
                numEdge++;
                numVertex++;
                String nameVertex = "Ant" + numVertex;
                String nameEdge = "a" + numEdge;
                if (!mngVertex.addVertex(nameVertex, distString, x, y, vertex.getName())) {
                    numVertex--;
                    numEdge--;
                    JOptionPane.showMessageDialog(null, "No se puede agregar otra antena en la misma posicion");
                } else {
                    mngEdge.addEdge(nameEdge, distString, nameVertex, vertex.getName());
                    graphics.drawString(nameEdge + "=" + distString, xString, yString);
                    graphics.drawLine(vertex.getX(), vertex.getY(), x, y);
                    graphics.drawImage(image, x - 15, y - 15, 30, 30, null);
                }
            } else {
                numVertex++;
                if (mngVertex.addVertex("Ant" + numVertex, distString, x, y, "")) {
                    graphics.drawImage(image, x - 15, y - 15, 30, 30, null);
                } else {
                    numVertex--;
                    JOptionPane.showMessageDialog(null, "No se puede agregar otra antena en la misma posicion");
                }

            }
        }
        super.paint(graphics);
    }

    private void addComponents() {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        drawLine(x, y);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
