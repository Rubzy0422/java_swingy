package com.wtc.swingy.View;

import com.wtc.swingy.View.Console.ConsoleView;
import com.wtc.swingy.View.GUI.GUIView;
import com.wtc.swingy.model.Level;

public final class ViewCreator {
    public static String viewType = "GUI";

    public static void initializeNew() {
        if (viewType.equals("CONSOLE"))
        {
            ConsoleView.initializeNew();
            return; 
        }
        GUIView.initializeNew();
    }

    public static void initializeGame() {
        if (viewType.equals("CONSOLE"))
        {
            ConsoleView.initializeGame();
            return; 
        }
        GUIView.initializeGame();
    }

    public static void initializeLoad() {
        if (viewType.equals("CONSOLE"))
        {
            ConsoleView.initializeLoad();
            return; 
        }
        GUIView.initializeLoad();
    }

    public static void initializeMain() {
        if (viewType.equals("CONSOLE"))
        {
            ConsoleView.initializeMain();
            return; 
        }
        GUIView.initializeMain();
	}

	public static int Dialog(String string) {
        if (viewType.equals("CONSOLE"))
            return ConsoleView.Dialog(string);
        return GUIView.Dialog(string);
	}

	public static void updateMap(Level level) {
        if (viewType.equals("CONSOLE"))
        {
            ConsoleView.updateMap(level);
            return; 
        }
        GUIView.updateMap(level);
	}

	public static void Infodlg(String string) {
        if (viewType.equals("CONSOLE"))
        {
            ConsoleView.Infodlg(string);
            return; 
        }
        GUIView.Infodlg(string);
	};


}
