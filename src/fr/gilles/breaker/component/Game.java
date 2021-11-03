package fr.gilles.breaker.component;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Game {
    public static  Scene scene;

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, FontFormatException {
        UIManager.setLookAndFeel(new FlatDarkLaf());
        scene = new Scene();
        scene.menu();
        scene.setVisible(true);
    }
}
