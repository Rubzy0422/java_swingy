/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wtc.swingy.view.GUI;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ruben
 */
public class GamePanel extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public List<JLabel> labels;
    private static int size;
    public GridLayout gl;

    public GamePanel(int _size) {
        super();
        gl = new GridLayout(_size, _size);
        super.setLayout(gl);
        this.setBackground(Color.BLACK);
        size = _size;
        this.labels = new ArrayList<>();
         
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                this.labels.add(new JLabel(""));
            }
        }  
//        this.setFocus
//        this.setLocationRelativeTo(null);
    }
    
    

    public void renderlabels()
    {
        this.removeAll();
//        int i = 0;
        for (JLabel label : this.labels)
        {
          
            label.setText("");
            this.add(label);
        }
        this.revalidate();
        this.repaint();
    }
    
    public void SetLabel(int x,int y, JLabel label)
    {
        int index = (y * size) + x;
        this.labels.set(index, label);
    }

    public int getMapSize()
    {
        return size;
    }
    
    public void clearMap()
    {
        labels.clear();
    }
    
    public void updateMapSize(int _Size)
    {
        this.gl.setColumns(_Size);
        this.gl.setRows(_Size);
        int cSize = ((_Size * _Size) - this.labels.size());
        for (int i = 0; i < cSize; i++)
            this.labels.add( this.labels.size() ,new JLabel());
        GamePanel.size = _Size;
    }
}
