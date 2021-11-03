package fr.gilles.breaker.router;

import fr.gilles.breaker.component.Game;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Navigator {

    public static  void gotoPanel( JPanel panel){
        Game.scene.setContentPane(panel);
        Game.scene.repaint();
    }

    public static  void startGame(){
        Game.scene.startGame();
    }

    public static  void goToSettings() throws IOException, FontFormatException {
        Game.scene.goToSettings();
    }

    public static void goToMenu() throws IOException, FontFormatException {
        Game.scene.menu();
    }
}
