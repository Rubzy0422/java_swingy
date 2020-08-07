/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wtc.swingy.view.GUI;

import com.sun.media.sound.EmergencySoundbank;
import com.wtc.swingy.controller.Controller;
import com.wtc.swingy.model.Champion;
import com.wtc.swingy.view.Console.ConsoleView;
import static com.wtc.swingy.view.Console.ConsoleView.cls;
import static com.wtc.swingy.view.Console.ConsoleView.updateMap;
import com.wtc.swingy.view.ImageUtil;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ruben
 */
public class GamePanel extends JPanel {
    private List<JLabel> labels;
    private static int size;
    private int lblWidth = 100;
    private int lblHeight = 100;
    
    public GamePanel(int size) {
        super(new GridLayout(size, size));
        this.size = size;
        this.labels = new ArrayList<JLabel>();
         
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                this.labels.add(new JLabel("O"));
            }
        }  
        
        this.addKeyListener(new Controller(){});
//        this.setLocationRelativeTo(null);
        this.requestFocus();
        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                lblWidth = Math.round(evt.getComponent().getWidth() / GamePanel.size);
                lblHeight = evt.getComponent().getHeight();
            }
        });
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
         int index = (y * this.size + x);
//         JLabel lbl = labels.get(index);
//         lbl = null;
         labels.set(index, label);
    }
//    Resize Event Set Icons 

    public int getMapSize()
    {
        return this.size;
    }
    
    public void clearMap()
    {
        for (JLabel lbl : this.labels)
            lbl = null;
        labels.clear();
    }
    
}
