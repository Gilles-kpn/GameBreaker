package fr.gilles.breaker.customize;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class GameSound {

    public  static  void playSound(String sound) throws URISyntaxException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        Clip clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(
                Objects.requireNonNull(GameSound.class.getResource("resources/sounds/" + sound))
        ));
        clip.start();

    }
}
