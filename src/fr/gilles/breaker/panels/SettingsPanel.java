package fr.gilles.breaker.panels;

import fr.gilles.breaker.customize.UI;
import fr.gilles.breaker.fileservice.FileService;
import fr.gilles.breaker.game.Difficult;
import fr.gilles.breaker.game.Settings;
import fr.gilles.breaker.router.Navigator;

import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class SettingsPanel extends JPanel {
    private GridBagConstraints constraints;
    public SettingsPanel() throws IOException, FontFormatException {
        setLayout(new GridBagLayout());
        initGridLayout();
        initTitle();
        initDifficulty();
        initSensibility();
        initPlayerPadColor();
        initBallColor();
        initTargetBlockColor();
        initMenuBack();
    }

    private void initGridLayout(){
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill = GridBagConstraints.CENTER;
        constraints.ipadx = 10;
    }

    public void loadSettings(){

    }

    private void initTitle() throws IOException, FontFormatException {
        JLabel label = new JLabel("Settings");
        label.setFont(UI.getFont().deriveFont(Font.PLAIN, 80));
        label.setHorizontalAlignment(SwingConstants.LEFT);
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(label,constraints);
    }

    private void initDifficulty() throws IOException, FontFormatException {
        JLabel label = new JLabel("Difficulty");
        label.setFont(UI.getFont().deriveFont(Font.PLAIN, 50));
        label.setHorizontalAlignment(SwingConstants.LEFT);

        JComboBox<String> difficulties = new JComboBox<>();
        difficulties.addItem("Easy");
        difficulties.addItem("Medium");
        difficulties.addItem("Hard");
        difficulties.setAlignmentX(LEFT_ALIGNMENT);
        difficulties.setSize(new Dimension(200, 40));

        difficulties.addActionListener(l->{
            switch ((String) Objects.requireNonNull(difficulties.getSelectedItem())){
                case "Easy" ->{
                   Settings.getSettings().difficult = Difficult.EASY.getDifficult();
                }
                case "Medium"->{
                    Settings.getSettings().difficult = Difficult.MEDIUM.getDifficult();
                }
                case "Hard"->{
                    Settings.getSettings().difficult = Difficult.HARD.getDifficult();
                }
            }
            System.out.println(difficulties.getSelectedItem());

        });
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(label,constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        add(difficulties,constraints);

    }

    private void initSensibility() throws IOException, FontFormatException {
        JLabel label = new JLabel("Sensibility");
        label.setFont(UI.getFont().deriveFont(Font.PLAIN, 50));


        JSlider slider = new JSlider();
        slider.setMinimum(2);
        slider.setMaximum(60);
        slider.setValue(Settings.getSettings().sensibility );

        slider.addChangeListener(l->{
            Settings.getSettings().sensibility = ((JSlider)l.getSource()).getValue();
        });
        constraints.gridx = 0;
        constraints.gridy = 2;
        add(label,constraints);
        constraints.gridx = 1;
        constraints.gridy = 2;
        add(slider,constraints);
    }

    private void initPlayerPadColor() throws IOException, FontFormatException {
        JLabel label = new JLabel("Pad Color");
        label.setFont(UI.getFont().deriveFont(Font.PLAIN, 50));

        JButton playerColor = new JButton("Click to select");
        playerColor.addActionListener(l->{
            Settings.getSettings().playerPadColor = JColorChooser.showDialog(this,"Choose color for player block", Color.BLUE);
        });
        constraints.gridx = 0;
        constraints.gridy = 3;
        add(label,constraints);
        constraints.gridx = 1;
        constraints.gridy = 3;
        add(playerColor,constraints);
    }

    private void initBallColor() throws IOException, FontFormatException {
        JLabel label = new JLabel("Ball Color");
        label.setFont(UI.getFont().deriveFont(Font.PLAIN, 50));

        JButton playerColor = new JButton("Click to select");
        playerColor.addActionListener(l->{
            Settings.getSettings().ballColor = JColorChooser.showDialog(this,"Choose color for ball", Color.WHITE);
        });
        constraints.gridx = 0;
        constraints.gridy = 4;
        add(label,constraints);
        constraints.gridx = 1;
        constraints.gridy = 4;
        add(playerColor,constraints);
    }

    private void initTargetBlockColor() throws IOException, FontFormatException {
        JLabel elabel = new JLabel("Easy Target Color");
        elabel.setFont(UI.getFont().deriveFont(Font.PLAIN, 50));

        JLabel mlabel = new JLabel("Medium Target Color");
        mlabel.setFont(UI.getFont().deriveFont(Font.PLAIN, 50));

        JLabel hlabel = new JLabel("Difficult Target Color");
        hlabel.setFont(UI.getFont().deriveFont(Font.PLAIN, 50));

        JButton easyTarget = new JButton("Click to select");
        easyTarget.addActionListener(l->{
            Settings.getSettings().easyTargetBlock = JColorChooser.showDialog(this,"Choose color for easy target block", Color.GREEN);
        });
        JButton mediumTarget = new JButton("Click to select");
        mediumTarget.addActionListener(l->{
            Settings.getSettings().easyTargetBlock = JColorChooser.showDialog(this,"Choose color for medium target block", Color.GREEN);
        });
        JButton hardTarget = new JButton("Click to select");
        hardTarget.addActionListener(l->{
            Settings.getSettings().easyTargetBlock = JColorChooser.showDialog(this,"Choose color for easy target block", Color.GREEN);
        });

        constraints.gridx = 0;
        constraints.gridy = 5;
        add(elabel,constraints);

        constraints.gridx = 1;
        constraints.gridy = 5;
        add(easyTarget,constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        add(mlabel,constraints);

        constraints.gridx = 1;
        constraints.gridy = 6;
        add(mediumTarget,constraints);

        constraints.gridx = 0;
        constraints.gridy = 7;
        add(hlabel,constraints);

        constraints.gridx = 1;
        constraints.gridy = 7;
        add(hardTarget,constraints);



    }

    private void initMenuBack(){
        JButton button = new JButton("Revenir au menu");
        button.addActionListener(l->{
            try {
                FileService.saveSettings();
                Navigator.goToMenu();

            } catch (IOException | FontFormatException e) {
                e.printStackTrace();
            }
        });

        constraints.gridx = 0;
        constraints.gridy = 8;
        add(button,constraints);
    }



}
