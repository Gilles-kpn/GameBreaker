package fr.gilles.breaker.Threads;

import fr.gilles.breaker.component.Game;
import fr.gilles.breaker.game.Settings;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

public class CollisionThread implements   Runnable, ActionListener {

    @Override
    public void run() {
        while(true){
            try {
                Game.scene.collision();
                Thread.sleep(1);
            }catch (InterruptedException | UnsupportedAudioFileException | LineUnavailableException | URISyntaxException | IOException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
