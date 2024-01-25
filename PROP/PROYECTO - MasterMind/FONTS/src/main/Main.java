package main;

import main.presentation.controllers.CtrlLogin;

import javax.swing.*;

/*
  @mainpage Projecte PROP: MasterMind
 En aquest projecte es desenvolupa una aplicació per jugar al MasterMind
 */

/* @file Main.java
 @brief Programa principal del projecte  <em>MasterMind</em>.
 */

/**
 * @brief Clase Main que llança l'aplicació
 */
public class Main {

    /**
     * @brief Función inicial que llança la interfície (en este cas per terminal)
     */
    public static void main(String[] args) {
    	try {
            //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); //per el que utilitzavem during development a linux
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //per que quedi to fresco a windows
        }
        catch (UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException |
               IllegalAccessException e) {
           // handle exception
        }
        CtrlLogin clogin = new CtrlLogin();
        clogin.run();
    }
}
