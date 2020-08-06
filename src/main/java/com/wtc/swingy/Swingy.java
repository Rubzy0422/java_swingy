package com.wtc.swingy;

import com.wtc.swingy.View.ViewCreator;

public class Swingy {
    static String View = "CONSOLE";

    public static void main(String[] args) {
        if (args.length >= 1)
        {
            if (args[0].toUpperCase().equals("CONSOLE"))
                View = "CONSOLE";
            else if (args[0].toUpperCase().equals("GUI"))
                View = "GUI";
        }    
        ViewCreator.viewType = View;
        ViewCreator.initializeMain();
    }

}
