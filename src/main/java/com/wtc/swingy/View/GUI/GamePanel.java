/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wtc.swingy.view.GUI;

import com.wtc.swingy.controller.Controller;
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
    private List<JLabel> labels;
    private static int size;


    public GamePanel(int _size) {
        super(new GridLayout(_size, _size));
        size = _size;
        this.labels = new ArrayList<JLabel>();
         
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                this.labels.add(new JLabel("O"));
            }
        }  
        
        this.addKeyListener(new Controller(){});
//        this.setLocationRelativeTo(null);
        this.requestFocus();

    }
    
    

    public void renderlabels()
    {
        this.removeAll();
        for (JLabel label : this.labels)
        {
            label.setText("");
            this.add(label);
//            System.out.println(label.getText());
        }
            
        this.repaint();
    }
    
    public void SetLabel(int x,int y, JLabel label)
    {
         int index = (y * size + x);
//         JLabel lbl = labels.get(index);
//         lbl = null;
         labels.set(index, label);
    }
//    Resize Event Set Icons 

    public int getMapSize()
    {
        return size;
    }
    
    public void clearMap()
    {
        labels.clear();
    }
    
}
