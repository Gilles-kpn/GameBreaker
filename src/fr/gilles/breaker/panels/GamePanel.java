package fr.gilles.breaker.panels;

import fr.gilles.breaker.blocks.BallBlock;
import fr.gilles.breaker.blocks.ObstaclesBlocks;
import fr.gilles.breaker.blocks.PlayerBlock;
import fr.gilles.breaker.customize.GameSound;
import fr.gilles.breaker.game.Settings;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.net.URISyntaxException;

public class GamePanel extends JPanel {
    private PlayerBlock playerBlock;
    private BallBlock ballBlock;
    private ObstaclesBlocks obstaclesBlocks;


    public GamePanel(){
        ballBlock = new BallBlock(new Point2D.Double(300,530),new Dimension(10,10),Settings.getSettings().ballColor);
        playerBlock = new PlayerBlock(new Point2D.Double(300,550),Settings.getSettings().playerPadColor);
        obstaclesBlocks = new ObstaclesBlocks(new Point2D.Double(10,10),new Dimension(960,200), Color.green);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //draw
        g.setColor(obstaclesBlocks.getColor());
        for (int i=0; i< obstaclesBlocks.getTargetBlocks().length ; i++)
            for (int y=0; y<obstaclesBlocks.getTargetBlocks()[0].length; y++){
                if (obstaclesBlocks.getTargetBlocks()[i][y].isShouldDraw())
                g.fillRect(
                        (int)(obstaclesBlocks.getTargetBlocks()[i][y].getPosition().getX()),
                        (int)(obstaclesBlocks.getTargetBlocks()[i][y].getPosition().getY()),
                        Settings.getSettings().dimension.width,
                        Settings.getSettings().dimension.height
                        );
            }


        //draw ball
        g.setColor(ballBlock.getColor());
        g.fillOval((int)ballBlock.getPosition().getX(),(int)ballBlock.getPosition().getY(), ballBlock.getDimension().width, ballBlock.getDimension().height);


        //draw player pad
        g.setColor(playerBlock.getColor());
        g.fillRect((int)playerBlock.getPosition().getX(), (int)playerBlock.getPosition().getY(), playerBlock.getDimension().width, playerBlock.getDimension().height);


    }

    public void movePlayerPadToRight(){
        if (playerBlock.getPosition().getX()+playerBlock.getDimension().width<getWidth()){
            playerBlock.setPosition(new Point2D.Double(playerBlock.getPosition().getX()+Settings.getSettings().sensibility,playerBlock.getPosition().getY()));
        }
    }

    public void movePlayerPadToLeft(){
        if (playerBlock.getPosition().getX() >0){
            playerBlock.setPosition(new Point2D.Double(playerBlock.getPosition().getX()- Settings.getSettings().sensibility,playerBlock.getPosition().getY()));
        }
    }

    public void moveBall() throws UnsupportedAudioFileException, LineUnavailableException, URISyntaxException, IOException {
       normalMoveBall();
    }

    public void playerCollisionMoveBall() throws UnsupportedAudioFileException, LineUnavailableException, URISyntaxException, IOException {
        if (ballBlock.getPosition().getY()+ballBlock.getDimension().height == playerBlock.getPosition().getY() && ballBlock.isMoveY()){
            if (ballBlock.getPosition().getX()>= playerBlock.getPosition().getX() && ballBlock.getPosition().getX() <= playerBlock.getPosition().getX()+playerBlock.getDimension().width){
                ballBlock.setMoveY(false);
                GameSound.playSound("ball-short-rebound.wav");
            }

        }
    }

    public  void normalMoveBall() throws UnsupportedAudioFileException, LineUnavailableException, URISyntaxException, IOException {
        if (ballBlock.isMoveX())
            ballBlock.setPosition(new Point2D.Double(ballBlock.getPosition().getX()+1, ballBlock.getPosition().getY()));
        else
            ballBlock.setPosition(new Point2D.Double(ballBlock.getPosition().getX()-1, ballBlock.getPosition().getY()));

        if (ballBlock.isMoveY()) {
            ballBlock.setPosition(new Point2D.Double(ballBlock.getPosition().getX(), ballBlock.getPosition().getY() + 1));
            //GameSound.playSound("ball-short-rebound.wav");
        }
        else{
            ballBlock.setPosition(new Point2D.Double(ballBlock.getPosition().getX(), ballBlock.getPosition().getY()-1));
            //GameSound.playSound("ball-short-rebound.wav");
        }


        if (ballBlock.getPosition().getX()+ballBlock.getDimension().getWidth()>getWidth() && ballBlock.isMoveX()){
            ballBlock.setMoveX(false);
            //GameSound.playSound("ball-short-rebound.wav");
        }

        if (ballBlock.getPosition().getX() < 0 && !ballBlock.isMoveX()){
            ballBlock.setMoveX(true);
            //GameSound.playSound("ball-short-rebound.wav");
        }


        if (ballBlock.getPosition().getY() < 0 && !ballBlock.isMoveY()){
            ballBlock.setMoveY(true);
            //GameSound.playSound("ball-short-rebound.wav");
        }

        if (ballBlock.getPosition().getY()+ballBlock.getDimension().height > getHeight() && ballBlock.isMoveY()){
            ballBlock.setMoveY(false);
            //GameSound.playSound("ball-short-rebound.wav");
        }

    }

    public   void checkTargetBlockCollision(){
        for (int i=0; i< obstaclesBlocks.getTargetBlocks().length ; i++)
            for (int y=0; y < obstaclesBlocks.getTargetBlocks()[0].length; y++ ){
                if(obstaclesBlocks.getTargetBlocks()[i][y].checkCollision(ballBlock))
                    obstaclesBlocks.getTargetBlocks()[i][y].setShouldDraw(false);
            }
    }


}
