package fr.gilles.breaker.customize;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static java.awt.Component.CENTER_ALIGNMENT;

public class UI {
    private static final File fontFile = new File(Objects.requireNonNull(UI.class.getResource("resources/fonts/Robus.otf")).getFile());

    public static void customizeButton(JButton button) throws IOException, FontFormatException {
        button.setMinimumSize(new Dimension(280, 40));
        button.setMaximumSize(new Dimension(280, 40));
        button.setPreferredSize(new Dimension(280, 40));
        button.setSize(new Dimension(280, 40));
        button.setFont(getFont());


        button.setAlignmentX(CENTER_ALIGNMENT);
    }

    public static Font getFont() throws IOException, FontFormatException {
        return Font.createFont(Font.TRUETYPE_FONT, fontFile ).deriveFont(Font.PLAIN, 40);
    }


    public static  ImageIcon loadIcon(String ico) throws IOException {
        return new ImageIcon(ImageIO.read(Objects.requireNonNull(UI.class.getResource("resources/images/" + ico))).getScaledInstance(30,20,Image.SCALE_SMOOTH));
    }
}
