/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wtc.swingy.view.GUI;

import javax.swing.JOptionPane;



public final class View {
   
 
    public static int Dialog(final String msg) {
        final int dialogResult = JOptionPane.showConfirmDialog(null, msg, "Info", JOptionPane.YES_OPTION,
                JOptionPane.NO_OPTION);
        return dialogResult;
    }

    public static void Infodlg(final String msg) {
        JOptionPane.showMessageDialog(null, msg);
   }

    
//    public static void initializeGame() {
////        updateMap(GameController.level);
//    }

//    public static void updateMap(final Level Map) {
//        ClearFrame(true);
//        JPanel jPanel = new JPanel();
//        jPanel.setLayout(new GridLayout(GameController.level.getSize(), GameController.level.getSize()));
//        jPanel.setBackground(Color.BLACK);
//        for (int y = 0; y < Map.getSize(); y++)
//            for (int x = 0; x < Map.getSize(); x++) {
//                boolean set = false;
//                final JLabel tmp = new JLabel();
//                for (final Champion Champ : Map.getChampions()) {
//                    if (Champ.getPlayerx() == x && Champ.getPlayery() == y) {
//                        final ImageIcon icon = ImageUtil.scaleImage(
//                                new ImageIcon("src/main/resources/" + Champ.getChampionClass() + ".png"), 100, 100);
//                        tmp.setIcon(icon);
//                        tmp.setText("");
//                        tmp.setToolTipText(Champ.getAttack() + " " + Champ.getDefence() + " "+ Champ.getHitPoints() + " "+ Champ.getExperience());
//                        set = true;
//                        break;
//                    }
//
//                }
//                if (!set) {
//                    final ImageIcon icon = ImageUtil.scaleImage(new ImageIcon("src/main/resources/Empty.png"),100, 100);
//                    tmp.setIcon(icon);
//                    tmp.setText("");
//                }
//                jPanel.add(tmp);
//            }
//     
//        frame.add(jPanel);
//    }


}