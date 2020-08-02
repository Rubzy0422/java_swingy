package com.wtc.swingy;

import com.wtc.swingy.View.ViewCreator;

public class Swingy {
    static boolean isRunning = true;
    static String State = "MAIN";
    static String View = "GUI";
    static ViewCreator ViewManager = null;
    // Possible States { "MAIN", "GAME", "CHAMP_CREATE", "PAUSE" };

    public static void main(String[] args) {

        if (args.length >= 1)
        {
            if (args[0].toUpperCase().equals("CONSOLE"))
                View = "CONSOLE";
            else if (args[0].toUpperCase().equals("GUI"))
                View = "GUI";
        }
        if (ViewManager == null)
            ViewManager = new ViewCreator(View);


        ViewManager.WelcomeWindowView();

//        1. Load All User Generated Champs From DB

//        Create new Level
//        Create new champion

//        Champion newChamp = new Champion("Name", "Wizard", 1, 0.0f,0.0f, 0.0f, 0.0f, false, 23);
//
//        System.out.println(newChamp);
//        EntityManager<Champion> entityManager = new EntityManager<Champion>();
//        entityManager.CreateField(newChamp);
//        entityManager.close();
    }

}
