/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uptc.visual;

import edu.uptc.logic.Vertex;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author javierpardo
 */
public class PanelButton extends JPanel implements ActionListener{
    private MainWindow mainWindow;
    private JButton btnViewMatrix;
    private JButton btnHelp;
    private JButton btnAbout;
    private Border borderButton;

    public PanelButton(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setLayout(new GridLayout(1, 5));
        beginComponets();
        addComponets();
    }
    
    private void beginComponets() {
        btnViewMatrix = new JButton("Matrices");
        btnViewMatrix.addActionListener(this);
        btnHelp = new JButton("Ayuda");
        btnHelp.addActionListener(this);
        btnAbout = new JButton("Acerda de");
        btnAbout.addActionListener(this);
        borderButton = new TitledBorder(new EtchedBorder(), "Opciones");
        setBorder(borderButton);
    }
    
    private void addComponets() {
        add(btnViewMatrix);
        add(btnHelp);
        add(btnAbout);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnViewMatrix){
            mainWindow.viewMatrix();
        }else if(e.getSource() == btnHelp){
            JOptionPane.showMessageDialog(null, "Para agregar una antena debe dar click en el panel de dibujo\nPara visualizar las matrices, grados y tipos de matrices, debe dar click en el boton Matrices");
        }else{
            JOptionPane.showMessageDialog(mainWindow, "INGENIERIA DE SISTEMAS Y COMPUTACION\nMATEMATICAS DISCRETAS\nDesarrolado por:\nJavier Pardo y Juan Jose Gutierrez", "Acerca del Software", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/img/logo.jpg")));
        }
    }
}
