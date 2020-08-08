package com.wtc.swingy.controller;

import java.awt.event.KeyListener;

import com.wtc.swingy.model.Level;

import java.awt.event.KeyEvent;

public abstract class Controller implements KeyListener {
      /**
     * Invoked when a key has been typed.
     * This event occurs when a key press is followed by a key release.
     */
    public void keyTyped(KeyEvent e) {}

    /**
     * Invoked when a key has been pressed.
     */
    // public void keyPressed(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() > 0)
            ikeyPressed(e.getKeyCode());
    }  

    public static void ikeyPressed(int k) {
        if (k == KeyEvent.VK_LEFT || k == KeyEvent.VK_A) {
            Level.MoveChamp(GameController.Champ, -1, 0);
            GameController.prev_x = -1;
            GameController.prev_y = 0;
            GameController.UpdateLevelInfo();
        }

        if (k == KeyEvent.VK_RIGHT || k == KeyEvent.VK_D) {
            Level.MoveChamp(GameController.Champ, 1, 0);
            GameController.prev_x = 1;
            GameController.prev_y = 0;
            GameController.UpdateLevelInfo();
        }

        if (k == KeyEvent.VK_UP || k == KeyEvent.VK_W) {
            Level.MoveChamp(GameController.Champ, 0, 1);
             GameController.prev_x = 0;
            GameController.prev_y = 1;
            GameController.UpdateLevelInfo();
        }

        if (k == KeyEvent.VK_DOWN || k == KeyEvent.VK_S) {
            Level.MoveChamp(GameController.Champ, 0, -1);
            GameController.prev_x = 0;
            GameController.prev_y = -1;
            GameController.UpdateLevelInfo();
        }
        if (k == KeyEvent.VK_ESCAPE || k == KeyEvent.VK_Q) {
            GameController.Exit();
        }


    }
    /**
     * Invoked when a key has been released.
     */
    public void keyReleased(KeyEvent e) {}
}