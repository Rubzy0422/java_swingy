/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wtc.swingy.view;
import com.wtc.swingy.view.Console.ConsoleView;
import com.wtc.swingy.view.GUI.View;
import com.wtc.swingy.controller.GameController;
import com.wtc.swingy.view.GUI.MainFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import com.wtc.swingy.model.Screens;
/**
 *
 * @author Ruben
 */
public class ViewCreator {
    public static String viewType = "";
    private static MainFrame MainFrame;
    
    public static void InitView(String _viewType)
    {
        viewType = _viewType;
        
        if (viewType.equals("GUI"))
        {
            MainFrame = new MainFrame();
            MainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            MainFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent evt) {
                  GameController.Exit();
                }
               });
            MainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            MainFrame.setLocationRelativeTo(null);
  
        
             
                /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    MainFrame.setVisible(true);
                }
            });
        }
    
        initializeMain();
    }
    
    public static void initializeNew() {
        if (viewType.equals("CONSOLE"))
        {
            ConsoleView.initializeNew();
            return; 
        }
        MainFrame.setView(Screens.NEW);
    }

    public static void initializeGame() {
        if (viewType.equals("CONSOLE"))
        {
            ConsoleView.initializeGame();
            return; 
        }
        MainFrame.setView(Screens.GAME);
        
    }


    public static void initializeLoad() {
        if (viewType.equals("CONSOLE"))
        {
            ConsoleView.initializeLoad();
            return; 
        }
        MainFrame.setView(Screens.LOAD);
    }

    public static void initializeMain() {
        if (viewType.equals("CONSOLE"))
        {
            ConsoleView.initializeMain();
            return; 
        }
        MainFrame.setView(Screens.MAIN);
    }

    public static int Dialog(String string) {
        if (viewType.equals("CONSOLE"))
            return ConsoleView.Dialog(string);
        return View.Dialog(string);
	}

    public static void Infodlg(String string) {
        if (viewType.equals("CONSOLE"))
        {
            ConsoleView.Infodlg(string);
            return; 
        }
        View.Infodlg(string);
	}
}
