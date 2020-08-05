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
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            Level.MoveChamp(GameController.Champ, -1, 0);
            GameController.UpdateLevelInfo("LEFT");
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            Level.MoveChamp(GameController.Champ, 1, 0);
            GameController.UpdateLevelInfo("RIGHT");
        }

        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            Level.MoveChamp(GameController.Champ, 0, 1);
            GameController.UpdateLevelInfo("UP");
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            Level.MoveChamp(GameController.Champ, 0, -1);
            GameController.UpdateLevelInfo("DOWN");
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            GameController.Exit();
        }


    }  
    /**
     * Invoked when a key has been released.
     */
    public void keyReleased(KeyEvent e) {}
}