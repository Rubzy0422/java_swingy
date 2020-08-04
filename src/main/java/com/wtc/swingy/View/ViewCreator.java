package com.wtc.swingy.View;

import com.wtc.swingy.View.Console.ConsoleView;
import com.wtc.swingy.View.GUI.GUIView;

public final class ViewCreator {

    public static void WelcomeWindowView(String viewType)
    {
        if (viewType.equals("GUI"))
            GUIView.initializeMain();
        if (viewType.equals("CONSOLE"))
            ConsoleView.initializeMain();
    };
}
