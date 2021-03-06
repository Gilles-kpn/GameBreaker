package fr.gilles.breaker.component;

import fr.gilles.breaker.Threads.CollisionThread;
import fr.gilles.breaker.Threads.GameThread;
import fr.gilles.breaker.game.Settings;
import fr.gilles.breaker.panels.GamePanel;
import fr.gilles.breaker.panels.Menu;
import fr.gilles.breaker.panels.SettingsPanel;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URISyntaxException;

public class Scene extends JFrame implements KeyListener {

    private GamePanel gamePanel ;
    private Menu menuPanel;
    private Thread gameThread ;
    private Thread collisionThread;
    private SettingsPanel settingsPanel;



    public Scene(){
        setTitle("Pong Game");
        setSize(800, 600);
        setMinimumSize(new Dimension(800, 600));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initAdapter();
        pack();
        initSettings();
    }

    void  initSettings(){
        Settings.init();
    }

    private void initAdapter(){
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                requestFocus();
                addKeyListener(Scene.this);
            }
        });
    }

    public void menu() throws IOException, FontFormatException {
        menuPanel = new Menu();
        menuPanel.setPreferredSize(new Dimension(800,600));
        menuPanel.setSize(new Dimension(800, 600));
        menuPanel.setMinimumSize(new Dimension(800, 600));
        setContentPane(menuPanel);
        repaint();
    }


    public void startGame(){
        gamePanel = new GamePanel();
        gamePanel.setSize(800, 600);
        gamePanel.setMinimumSize(new Dimension(800, 600));
        gamePanel.addKeyListener(this);
        requestFocus();
        setFocusTraversalKeysEnabled(false);
        this.setContentPane(gamePanel);
        System.out.println(gamePanel.getSize());
        gameThread = new Thread(new GameThread());
        collisionThread = new Thread(new CollisionThread());
        gameThread.start();
        collisionThread.start();

    }

    public void repaintGamePanel() throws UnsupportedAudioFileException, LineUnavailableException, URISyntaxException, IOException {
        gamePanel.repaint();
        gamePanel.moveBall();

    }


    public void collision() throws UnsupportedAudioFileException, LineUnavailableException, URISyntaxException, IOException {
        gamePanel.playerCollisionMoveBall();
        gamePanel.checkTargetBlockCollision();
    }


    public void goToSettings() throws IOException, FontFormatException {
        settingsPanel = new SettingsPanel();

        JScrollPane settings = new JScrollPane(settingsPanel);
        settings.setPreferredSize(new Dimension(800,600));
        settings.setSize(new Dimension(800, 600));
        settings.setMinimumSize(new Dimension(800, 600));
        setContentPane(settings);
        repaint();
    }


    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()){
            case KeyEvent.VK_LEFT -> gamePanel.movePlayerPadToLeft();
            case KeyEvent.VK_RIGHT ->gamePanel.movePlayerPadToRight();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }



}
