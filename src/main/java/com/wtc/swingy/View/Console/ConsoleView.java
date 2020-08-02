package com.wtc.swingy.View.Console;

import java.io.IOException;

import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.bundle.LanternaThemes;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.DefaultWindowManager;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class ConsoleView {
    
 // Setup terminal and screen layers
 
    public void CreateScreen()
    {
        Terminal terminal;
        try {
            terminal = new DefaultTerminalFactory().createTerminal();
       
            Screen screen = new TerminalScreen(terminal);
        //     screen.startScreen();
    
            
        //     Label label = new Label("Test");
        // // Label label = new Label("test");
    
        // BasicWindow window = new BasicWindow();
        // window.setComponent(label);
    
        // MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(),
        //     new EmptySpace(TextColor.ANSI.BLACK));
        // gui.setTheme(LanternaThemes.getRegisteredTheme("businessmachine"));
        // gui.addWindowAndWait(window);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }
    public void initializeNew() {
        
    }

    public void initializeMain() {
        CreateScreen();
        System.out.println("_______________ MAIN _______________");
    }

    public void initializeLoad() {
        System.out.println("_______________ LOAD _______________");
    }

    public void initializeGame(int lvl) {
        System.out.println("_______________ LVL"+ lvl +  "_______________");
    }

}
