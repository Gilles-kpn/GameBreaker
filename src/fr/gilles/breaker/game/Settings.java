package fr.gilles.breaker.game;

import java.awt.*;

public class Settings {
    private static  Settings settings;
    public int sensibility = 15;
    public  int difficult = Difficult.MEDIUM.getDifficult();
    public Color playerPadColor = Color.BLUE;
    public Color ballColor = Color.WHITE;
    public Color easyTargetBlock = Color.GREEN;
    public Color mediumTargetBlock = Color.GREEN;
    public Color hardTargetBlock = Color.GREEN;
    public Dimension dimension = new Dimension(30,10);


    private Settings(){

    }

    @Override
    public String toString() {
        return "Settings{" +
                "sensibility=" + sensibility +
                ", difficult=" + difficult +
                ", playerPadColor=" + playerPadColor.getRGB() +
                ", ballColor=" + ballColor.getRGB() +
                ", easyTargetBlock=" + easyTargetBlock .getRGB()+
                ", mediumTargetBlock=" + mediumTargetBlock.getRGB() +
                ", hardTargetBlock=" + hardTargetBlock.getRGB() +
                '}';
    }

    public static void init(){
        if(settings == null) settings = new Settings();
    }
    public static  Settings getSettings(){
        return settings;
    }
}
