/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wtc.swingy;

import com.wtc.swingy.view.ViewCreator;
import javax.swing.SwingUtilities;
/**
 *
 * @author Ruben
 */
public class Swingy {

       public static void main(String args[]) {
           if (args.length >= 1)
            {
                if (args[0].toUpperCase().equals("CONSOLE"))
                    ViewCreator.InitView("CONSOLE");
                else if (args[0].toUpperCase().equals("GUI"))
                    ViewCreator.InitView("GUI");
            }
            else
                 ViewCreator.InitView("CONSOLE");
//                System.err.println("java -jar Swingy [GUI / CONSOLE]");
       }
}
