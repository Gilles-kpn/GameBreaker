package fr.gilles.breaker.Threads;

import fr.gilles.breaker.component.Game;
import fr.gilles.breaker.game.Settings;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameThread implements  Runnable{


    @Override
    public void run() {
        while(true){

            try {
                Game.scene.repaintGamePanel();
                Thread.sleep(Settings.getSettings().refreshFrequency);
            }catch (InterruptedException | UnsupportedAudioFileException | LineUnavailableException | URISyntaxException | IOException e){
                e.printStackTrace();
            }
        }
    }
}
