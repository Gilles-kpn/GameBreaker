package fr.gilles.breaker.panels;

import fr.gilles.breaker.customize.GameSound;
import fr.gilles.breaker.customize.UI;
import fr.gilles.breaker.router.Navigator;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Menu extends JPanel {
    private final Box box;

    public Menu() throws IOException, FontFormatException {
        box = Box.createVerticalBox();
        initMenu();
        initBoxLayout();

    }

    private  void initBoxLayout(){

        this.add(box);

    }


    private void initMenu() throws IOException, FontFormatException {
        initGameLabel();
        initStartGame();
        initHistory();
        initSettings();
        initOthersButton();
    }

    private void initGameLabel() throws IOException, FontFormatException {
        JLabel label = new JLabel("Pong Game");
        label.setFont(UI.getFont().deriveFont(Font.PLAIN, 80));
        label.setAlignmentX(CENTER_ALIGNMENT);
        box.add(label);

    }

    private void initStartGame() throws IOException, FontFormatException {
        JButton start = new JButton("Start Game");
        UI.customizeButton(start);
        start.addActionListener((actionEvent)->{
            try {
                GameSound.playSound("button-click.wav");
                Navigator.startGame();
            } catch (URISyntaxException | UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        });

        box.add(start);

    }

    private void initOthersButton() throws IOException {
        JButton sound = new JButton();
        sound.setIcon(UI.loadIcon("room-sound.png"));

        JButton share = new JButton();
        share.setIcon(UI.loadIcon("share.png"));

        JButton about = new JButton();
        about.setIcon(UI.loadIcon("info.png"));

        JPanel othersButtons = new JPanel();
        othersButtons.setMaximumSize(new Dimension(280, 40));
        othersButtons.setLayout(new BorderLayout());
        othersButtons.add(sound, BorderLayout.WEST);
        othersButtons.add(share, BorderLayout.CENTER);
        othersButtons.add(about, BorderLayout.EAST);
        othersButtons.setAlignmentX(CENTER_ALIGNMENT);
        box.add(othersButtons);
    }

    private void initSettings() throws IOException, FontFormatException {
        JButton settings = new JButton("Settings");
        UI.customizeButton(settings);
        settings.addActionListener((actionEvent)->{

        });
        box.add(settings);
    }

    private void initHistory() throws IOException, FontFormatException {
        JButton history = new JButton("History");
        UI.customizeButton(history);
        history.addActionListener((actionEvent)->{

        });
        box.add(history);
    }


}
