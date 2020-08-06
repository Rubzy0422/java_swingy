package com.wtc.swingy.View.Console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.wtc.swingy.controller.Controller;
import com.wtc.swingy.controller.GameController;
import com.wtc.swingy.model.Champion;
import com.wtc.swingy.model.ChampionClass;
import com.wtc.swingy.model.Level;
import java.util.logging.Logger;

public final class ConsoleView {
    private static BufferedReader buffreader = new BufferedReader(new InputStreamReader(System.in));
    private static String Name;

    public static void cls() {
        System.out.print("\u001B[2J");
        System.out.flush();
    }

    public static void initializeMain() {
        cls();
        System.out.println("MAIN MENU");
        System.out.println("1. Play Game");
        System.out.println("2. Load Game");
        System.out.println("3. Exit");

        try {
            String Option = buffreader.readLine().trim();
            // System.out.println(Option);
            if (Option.equals("1"))
                GameController.initializeNew();
            else if (Option.equals("2"))
                GameController.initializeLoad();
            else if (Option.equals("3"))
                GameController.Exit();
            else
                initializeMain();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

    public static void initializeNew() {
        cls();
        System.out.println("Champ Create: ");
        System.out.println(GameController.Champ);

        System.out.println("\n\n\n\n");

        System.out.println("1. Set Champion Name");
        System.out.println("2. Set Champion Class");
        System.out.println("3. Start Game");
        System.out.println("4. Main Menu");
        System.out.println("'x' GUI MODE");

        try {
            String Option = buffreader.readLine().trim();
            // System.out.println(Option);
            if (Option.equals("1")) {
                cls();
                System.out.println("ENTER Player Name:");
                Name = buffreader.readLine().trim();
                GameController.PlayerNameUpdate(Name);
                initializeNew();
            } else if (Option.equals("2")) {
                cls();
                System.out.println("Select Class:");
                int i = 0;
                for (ChampionClass cc : ChampionClass.values()) {
                    System.out.println(i + " " + cc.name());
                    i++;
                }
                int ans = Integer.parseInt(buffreader.readLine().trim());
                if (ans < i && ans >= 0)
                    GameController.Champ.setChampionClass(ChampionClass.values()[ans]);
                initializeNew();
            } else if (Option.equals("3")) {
                if (GameController.ValidateStart())
                    GameController.initializeGame("NEW");
                else
                    initializeNew();
            } else if (Option.equals("4")) {
                GameController.initializeMain();
            } else if (Option.equals("x")) {
                System.out.println("STILL TO ADD");
            } else
                initializeNew();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

    public static void initializeGame() {
        cls();
        updateMap(GameController.level);
    }

    public static void initializeLoad() {
        cls();
        // PRINT THINGYS
        System.out.println("Load MENU");
       
        if (GameController.Champ != null)
            System.out.println(GameController.Champ);
        else {
            System.out.println("Select Champion");
        }

        System.out.println("\n\n\n\n");
        System.out.println("1. Select Game");
        System.out.println("2. Play");
        System.out.println("3. Main Menu");

        try {
            String Option = buffreader.readLine().trim();
            // System.out.println(Option);
            if (Option.equals("1"))
            {
                cls();
                System.out.println("LOAD GAME");
                int i = 0;
                for(Level lvl : GameController.levels){
                    System.out.println(lvl.toString());
                    i++;
                }   
                Option = buffreader.readLine().trim();
                if (!Option.isBlank())
                {
                    int ans = Integer.parseInt(buffreader.readLine().trim());
                    if (ans < i && ans >= 0)
                        GameController.LoadGame(i);
                }
            }
            else if (Option.equals("2"))
            {
                if (GameController.Champ != null)
                    GameController.initializeGame("OLD");
            }
            else if (Option.equals("3"))
                GameController.initializeMain();    
            initializeLoad();
        } catch (Exception ex)
        {
            System.out.println(ex);
        }
    }

    public static int Dialog(String string) {
        cls();
        System.out.println(string);
       try {
            String Option = buffreader.readLine();
        
            if (!Option.isEmpty()) {
                Character c = Option.toUpperCase().charAt(0);
                if (c ==  'Y')
                    return 0;
            }
            return 1;
        }
       catch (Exception e)
       {
           System.out.println(e);
       }
        return 0;
    }

    public static void updateMap(Level level) {
        cls();
        // RENDER OUT GAME
        int size = level.getSize();

        StringBuilder sb = new StringBuilder();

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                sb.append(".");
            }
            sb.append("\n");
        }

        for (Champion Champ : level.getChampions()) {
            Character c = Champ.getChampionClass().name().charAt(0);
            if (Champ.isUserGenerated())
                c = '0';
            int x = Champ.getPlayerx();
            int y = Champ.getPlayery();
            int index = (y * size + x) + y;
            sb.setCharAt(index, c);
        }

        System.out.println(sb.toString());

        try {
            String Option = buffreader.readLine().trim();

            if (!Option.isEmpty()) {
                int i = Integer.valueOf(Option.toUpperCase().charAt(0));
                if (i > 0) {
                    Controller.ikeyPressed(i);
                }
            }
        }
        catch (IOException ex) {
            Logger.getLogger(ConsoleView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        
        // GET INPUT FROM KEY PRESS
	}

	public static void Infodlg(String string) {
        cls();
        System.out.println(string);
       try {
           buffreader.readLine();
       }
       catch (Exception e)
       {
           System.out.println(e);
       }
	}
}
