package fr.gilles.breaker.component;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Game {
    public static  Scene scene;

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, FontFormatException {
        UIManager.setLookAndFeel(UIManager.getInstalledLookAndFeels()[3].getClassName());
        scene = new Scene();
        scene.init();
    }
}
