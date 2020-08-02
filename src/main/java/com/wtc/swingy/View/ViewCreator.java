package com.wtc.swingy.View;

import com.wtc.swingy.View.Console.ConsoleView;
import com.wtc.swingy.View.GUI.GUIView;

public class ViewCreator {
    private String viewType;
    private GUIView _guiView;
    private ConsoleView _consoleView;

    public ViewCreator(String viewType)
    {
        this.viewType = viewType;
//        Create Children
        if (viewType.equals("GUI"))
            this._guiView = new GUIView();
        if (viewType.equals("CONSOLE"))
            this._consoleView = new ConsoleView();
    }

    public void WelcomeWindowView()
    {
        if (this.viewType.equals("GUI"))
            this._guiView.initializeMain();
        else
            if (this.viewType.equals("CONSOLE"))
                this._consoleView.initializeMain();
    };
}
