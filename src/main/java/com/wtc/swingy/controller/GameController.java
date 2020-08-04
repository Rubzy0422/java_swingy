package com.wtc.swingy.controller;


import java.util.Random;

import com.wtc.swingy.View.GUI.GUIView;
import com.wtc.swingy.model.Champion;
import com.wtc.swingy.model.ChampionClass;
import com.wtc.swingy.model.Level;
import com.wtc.swingy.model.Persistance;




public final class GameController  {

    public static String PlayerDetails;
    public static ChampionClass chosenClass;
    public static Champion Champ;
    public static Level level;
    public static Controller KeyLog;

    public static void CreateNewChamp() {
        Champ = new Champion("", ChampionClass.WARRIOR, 1, 0.0f, true, 4, 4);
        chosenClass = Champ.getChampionClass();
    }

    public static String PlayerNameUpdate(String Name) {
        Champ.setName(Name);
        PlayerDetails = Champ.toString();
        return Name;
    }

    public static boolean ValidateStart() {
        return (!Champ.getName().isEmpty());
    }

    public static void initializeNew() {
        CreateNewChamp();
        GUIView.initializeNew();
    }

    public static void initializeGame(String GameStatus) {
        if (GameStatus.equals("NEW")) {
            level = new Level();
            level.addChampion(Champ);
            GenerateChampions();

            Persistance.SaveEntity(level);
            GUIView.initializeGame();
        }
    }

    public static void GenerateChampions()
    {
        Random rand = new Random();
        int numx;
        int numy;
        int ChampAmount = rand.nextInt(level.getSize() - 1) * 3; 
        for (int y = 0; y < ChampAmount; y++) {
            numx = rand.nextInt(level.getSize());
            numy = rand.nextInt(level.getSize());
        
            Champion tmp = new Champion("RAND", ChampionClass.values()[rand.nextInt(2)], rand.nextInt(3) + 1 , rand.nextFloat() * 40.0f, false, numx, numy);
            level.addChampion(tmp);
        }
   }

    public static void initializeLoad() {

    }

    public static void initializeMain() {
        Champ = null;
        GUIView.initializeMain();
    }

    public static void UpdateLevelInfo() {
        if (ChampionCollide())
        {
            System.out.println("BAttle!");
        }
        if (Champ.getPlayerx() < 0 || Champ.getPlayery() < 0 || Champ.getPlayerx() >= level.getSize() || Champ.getPlayery() >= level.getSize())
        {
            System.out.println("Congrats you won on level:"  + level.getMapLevel());
            Persistance.delete(level);
            Exit();
        }
        GUIView.updateMap(level);
    }

    public static boolean ChampionCollide() {
        for (Champion _enem : Champ.getEnemies())
        {
            if (Champ.getPlayerx() == _enem.getPlayerx() && Champ.getPlayery() == _enem.getPlayery())
                return true;
        }
        return false;
    }

    public static void Exit() {
        System.exit(0);
    }
}
