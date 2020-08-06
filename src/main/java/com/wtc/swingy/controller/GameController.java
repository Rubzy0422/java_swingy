package com.wtc.swingy.controller;

import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import com.wtc.swingy.View.ViewCreator;
import com.wtc.swingy.model.Artifact;
import com.wtc.swingy.model.Champion;
import com.wtc.swingy.model.ChampionClass;
import com.wtc.swingy.model.Level;
import com.wtc.swingy.model.Persistance;


public final class GameController  {

    public static String PlayerDetails;
    public static ChampionClass chosenClass;
    public static Champion Champ;
    public static Level level;
    public static List<Level> levels;
    public static Controller KeyLog;
    private static Persistance<Level> pers = new Persistance<Level>();
    private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static javax.validation.Validator validator = factory.getValidator();

    public static void CreateNewChamp() {
        Champ = new Champion("", ChampionClass.WARRIOR, 0, true, 4, 4);
        chosenClass = Champ.getChampionClass();
    }

    public static String PlayerNameUpdate(final String Name) {
        Champ.setName(Name);
        PlayerDetails = Champ.toString();
        return Name;
    }

    public static boolean ValidateStart() {
        String ValidationProblems = "";
        Set<ConstraintViolation<Champion>> constraintViolations = validator.validate(Champ);
     
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<Champion> violation : constraintViolations) {
                ValidationProblems += violation.getMessage() + "\n";
            }
        }
        if (!ValidationProblems.isEmpty())
            ViewCreator.Infodlg(ValidationProblems);
        return constraintViolations.size() <= 0;
    }

    public static void initializeNew() {
        CreateNewChamp();
        ViewCreator.initializeNew();
    }

    public static void initializeGame(final String GameStatus) {
        if (GameStatus.equals("NEW")) {
            level = new Level();
            level.addChampion(Champ);
            GenerateChampions();
            pers.SaveEntity(level);
        }
        ViewCreator.initializeGame();
    }

    public static void GenerateChampions() {
        final Random rand = new Random();
        
        final int ChampAmount = (rand.nextInt(level.getSize() - 2) + 1) * 3;
        for (int y = 0; y < ChampAmount; y++) {
            GenerateChampion();
        }
    }

    public static boolean taken(int numx, int  numy) {
        for (Champion c : level.getChampions())
        {   
            if (c.getPlayerx() == numx && c.getPlayery() == numy)
                return true;
        }
        return false;
    }

    public static void GenerateChampion() {
        final Random rand = new Random();
        int numx = rand.nextInt(level.getSize());
        int numy = rand.nextInt(level.getSize());
        
        while (taken(numx, numy))
        {
            numx = rand.nextInt(level.getSize());
            numy = rand.nextInt(level.getSize());
        }

        // System.out.println(Champ.getAttack() + 4);

        int attack =  rand.nextInt(Champ.getAttack() + 4); 
        int defense = rand.nextInt(Champ.getDefence() + 4); 
        int hitPoints = rand.nextInt(Champ.getHitPoints() + 4); 

        int VillanPower = Math.round((attack + defense + hitPoints) / 3);

        Artifact artifact = new Artifact(VillanPower > 0 ? VillanPower: 1);

        int xp = rand.nextInt(Champ.getExperience() + 1);
        
        final Champion tmp = new Champion("RAND", ChampionClass.values()[rand.nextInt(2)], xp, false, numx, numy);
        tmp.setAttack(attack);
        tmp.setDefence(defense);
        tmp.setHitPoints(hitPoints);
        tmp.setArtifact(artifact);
        level.addChampion(tmp);
    }

    public static void initializeLoad() {
        levels = pers.em.createQuery("Select a from Level a", Level.class).getResultList();
        // System.out.println(lvls);
        // for (Level lvl : levels) {
        //     // 1. Get player Champion 
        //     // 2. on champion Select Load Level (PlayBtn)
        //     System.out.println(lvl.getSize());
        // }
        ViewCreator.initializeLoad();
    }

    public static String LoadGame(int index) {
        if (index != -1)
        {
            level = levels.get(index);
            Champ = level.getChampions().get(0);
        }
        return Champ.toString();
    }

    public static void initializeMain() {
        Champ = null;
        ViewCreator.initializeMain();
    }

    public static void UpdateLevelInfo(String Movement) {
        Champion _enem = ChampionCollide();
        if (_enem != null) {
            if (ViewCreator.Dialog("Would you like to fight [Y/N]?") == 0) {
                Battle(_enem);
            }
            else {
                Flee(Movement, _enem);
            }
        }

        if (Champ.getPlayerx() < 0 || Champ.getPlayery() < 0 || Champ.getPlayerx() >= level.getSize()
                || Champ.getPlayery() >= level.getSize()) {
            System.out.println("Congrats you won on level:" + level.getMapLevel());
            pers.delete(level);
            level = null;
            Exit();
        }
        ViewCreator.updateMap(level);
    }

    private static void Flee(String Movement, Champion _enem) {
        Random rand = new Random();
        int test = rand.nextInt(1);


        if ((test % 2 ) == 1) {
            switch (Movement) {
//            MOVE BACK
                case "LEFT": {
                    Level.MoveChamp(Champ, 1, 0);
                    break;
                }
                case "RIGHT": {
                    Level.MoveChamp(Champ, -1, 0);
                    break;
                }
                case "UP": {
                    Level.MoveChamp(Champ, 0, -1);
                    break;
                }
                case "DOWN": {
                    Level.MoveChamp(Champ, 0, 1);
                    break;
                }
            }
        }
        else {
            Battle(_enem);
        }
    }

    private static void Battle(Champion _enem) {
        Random rand = new Random();
        // System.out.println("Battle!");
        int points = Champ.compare(_enem);
        if (points >= 0)
        {
            Champ.setExperience(Champ.getExperience() + points);
            level.removeChampion(_enem);
            if (rand.nextInt(100) % 5 == 0)
            {
                if (ViewCreator.Dialog("Do You want Artifact: " + _enem.getArtifact() + "[Y/N] ?") == 0)
                    Champ.setArtifact(_enem.getArtifact());
            }
            else {
                ViewCreator.Infodlg("Battle Won!");
            }
            GenerateChampion();
        }
        else {
            ViewCreator.Infodlg("You Lost the Mission!");
            pers.delete(level);
            level = null;
            Exit();
        }

    }

    public static Champion ChampionCollide() {
        for (final Champion _enem : Champ.getEnemies())
        {
            if (Champ.getPlayerx() == _enem.getPlayerx() && Champ.getPlayery() == _enem.getPlayery())
                return _enem;
        }
        return null;
    }

    public static void Exit() {
        if (level != null) {
            pers.SaveEntity(level);
            pers.CompletePersist();
        }
        System.exit(0);
    }
}
