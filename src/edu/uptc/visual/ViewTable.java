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
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneLayout;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author javierpardo
 */
public class ViewTable extends JDialog {

    private MainWindow mainWindow;
    private Vector<String> columnNamesAd;
    private Vector<String> columnNamesIn;
    private DefaultTableModel dtm;
    private DefaultTableModel dtmIn;
    private JTable table;
    private JTable tableIn;
    private JScrollPane scrollPaneAd;
    private JScrollPane scrollPaneIn;
    private Border borderTableAd;
    private Border borderTableIn;
    private MngVertex mngVertex;
    private MngEdge mngEdge;
    private JPanel pnlTable;

    public ViewTable(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setSize(new Dimension(1000, 500));
        setLayout(new BorderLayout());
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        begin();
    }

    private void begin() {
        beginComponents();
        addComponents();
    }

    private void beginComponents() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                pnlTable.removeAll();
                dispose();
            }
        });
        mngVertex = mainWindow.getVertex();
        mngEdge = mainWindow.getEdge();
        pnlTable = new JPanel();
    }

    private void addComponents() {

    }

    public void viewMatrix() {
        columnNamesAd = new Vector<>();
        columnNamesAd.add("MA");
        ArrayList<Vertex> verticesAd = mngVertex.getVertexs();
        if (verticesAd.size() > 0) {
            for (int i = 0; i < verticesAd.size(); i++) {
                columnNamesAd.add(verticesAd.get(i).getName());
            }
        }
        columnNamesAd.add("Grado");
        columnNamesAd.add("Tipo");
        dtm = new DefaultTableModel(columnNamesAd, verticesAd.size());
        if (mainWindow.getVertex().getVertexs().size() > 0) {
            for (int i = 0; i < verticesAd.size(); i++) {
                dtm.setValueAt(verticesAd.get(i).getName(), i, 0);
            }
        }
        for (int i = 0; i < verticesAd.size(); i++) {
            for (int j = 0; j < verticesAd.size(); j++) {
                if (verticesAd.get(i).getName().equals(verticesAd.get(j).getVertexUnion()) || verticesAd.get(j).getName().equals(verticesAd.get(i).getVertexUnion())) {
                    dtm.setValueAt("1", i, j + 1);
                } else {
                    dtm.setValueAt("0", i, j + 1);
                }
            }

        }
        int sum = 0;
        for (int i = 0; i < dtm.getRowCount(); i++) {
            for (int j = 1; j < dtm.getColumnCount() - 2; j++) {
                sum += Integer.parseInt(dtm.getValueAt(i, j).toString());
            }
            dtm.setValueAt(sum, i, dtm.getColumnCount() - 2);
            if (sum == 0) {
                dtm.setValueAt("Aislada", i, dtm.getColumnCount() - 1);
            } else if (sum == 1) {
                dtm.setValueAt("Terminal", i, dtm.getColumnCount() - 1);
            } else {
                dtm.setValueAt("Central", i, dtm.getColumnCount() - 1);
            }
            sum = 0;
        }
        table = new JTable(dtm);
        scrollPaneAd = new JScrollPane(table);
        table.getColumnModel().getColumn(0).setCellRenderer(table.getTableHeader().getDefaultRenderer());
        table.getColumnModel().getColumn(dtm.getColumnCount() - 2).setCellRenderer(table.getTableHeader().getDefaultRenderer());
        table.getColumnModel().getColumn(dtm.getColumnCount() - 1).setCellRenderer(table.getTableHeader().getDefaultRenderer());
        table.setEnabled(false);
        scrollPaneAd = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        borderTableAd = new TitledBorder(new EtchedBorder(), "Matriz Adyacencia");
        scrollPaneAd.setBorder(borderTableAd);
        pnlTable.add(scrollPaneAd);
        
        columnNamesIn = new Vector<>();
        columnNamesIn.add("MI");
        ArrayList<Edge> edgesIn = mngEdge.getEdges();
        ArrayList<Vertex> verticesIn = mngVertex.getVertexs();
        if (edgesIn.size() > 0) {
            for (int i = 0; i < edgesIn.size(); i++) {
                columnNamesIn.add(edgesIn.get(i).getName());
            }
        }
        dtmIn = new DefaultTableModel(columnNamesIn, verticesIn.size());
        if (verticesIn.size() > 0) {
            for (int i = 0; i < verticesIn.size(); i++) {
                dtmIn.setValueAt(verticesIn.get(i).getName(), i, 0);
            }
        }
        for (int i = 0; i < verticesIn.size(); i++) {
            for (int j = 0; j < edgesIn.size(); j++) {
                if (verticesIn.get(i).getName().equals(edgesIn.get(j).getVertex2()) || verticesIn.get(i).getName().equals(edgesIn.get(j).getVertex1())) {
                    dtmIn.setValueAt("1", i, j + 1);
                } else {
                    dtmIn.setValueAt("0", i, j + 1);
                }
            }

        }
        tableIn = new JTable(dtmIn);
        tableIn.getColumnModel().getColumn(0).setCellRenderer(tableIn.getTableHeader().getDefaultRenderer());
        tableIn.setEnabled(false);
        scrollPaneIn = new JScrollPane(tableIn, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        borderTableIn = new TitledBorder(new EtchedBorder(), "Matriz Incidencia");
        scrollPaneIn.setBorder(borderTableIn);
        pnlTable.add(scrollPaneIn);
        pnlTable.setPreferredSize(new Dimension(800, 300));
        add(pnlTable);
    }
}
