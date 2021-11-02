package fr.gilles.breaker.router;

import fr.gilles.breaker.component.Game;

import javax.swing.*;

public class Navigator {

    public static  void gotoPanel( JPanel panel){
        Game.scene.setContentPane(panel);
        Game.scene.repaint();
    }

    public static  void startGame(){
        Game.scene.startGame();
    }
}
