package fr.gilles.breaker.blocks;

import java.awt.*;
import java.awt.geom.Point2D;

public class TargetBlock extends GameBlock{
    private boolean shouldDraw = true;

    public TargetBlock(Point2D position, Dimension dimension, Color color) {
        super(position, dimension, color);
    }


    public boolean checkCollision(BallBlock ballBlock){
        if (shouldDraw){
            if (ballBlock.getPosition().getX() >= position.getX() && ballBlock.getPosition().getX() <= position.getX()+dimension.getWidth()){
                if (ballBlock.getPosition().getY()+ballBlock.getDimension().height == position.getY() && ballBlock.isMoveY()){
                    //collision venant du haut
                    ballBlock.setMoveY(false);
                    return true;
                }

                if (ballBlock.getPosition().getY() == position.getY()+dimension.height &&  !ballBlock.isMoveY()){
                    ballBlock.setMoveY(true);
                    return  true;
                }
            }

            if (ballBlock.getPosition().getY()>=position.getY() && ballBlock.getPosition().getY() <= position.getY()+ dimension.height){

                if (ballBlock.getPosition().getX()+ballBlock.getDimension().width == position.getY() && ballBlock.isMoveX()){
                    ballBlock.setMoveX(false);
                    return  true;
                }

                if(ballBlock.getPosition().getY() == position.getX()+dimension.width && !ballBlock.isMoveX()){
                    ballBlock.setMoveX(true);
                    return  true;
                }


            }

            return  false;
        }
        return  false;
    }

    public boolean isShouldDraw() {
        return shouldDraw;
    }

    public void setShouldDraw(boolean shouldDraw) {
        this.shouldDraw = shouldDraw;
    }
}
