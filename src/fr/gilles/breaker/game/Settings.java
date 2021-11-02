package fr.gilles.breaker.game;

import java.awt.*;

public class Settings {
    private static  Settings settings;
    public int sensibility = 10;
    public  int refreshFrequency = 5;
    public Dimension dimension = new Dimension(30,10);

    private Settings(){

    }


    public static void init(){
        if(settings == null) settings = new Settings();
    }

    public static  Settings getSettings(){
        return settings;
    }
}
