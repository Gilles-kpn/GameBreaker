package fr.gilles.breaker.blocks;

import java.awt.*;
import java.awt.geom.Point2D;

public class BallBlock extends GameBlock{
    private  boolean moveX = true;
    private boolean moveY = true;

    public BallBlock(Point2D position, Dimension dimension, Color color) {
        super(position, dimension, color);
    }

    public boolean isMoveX() {
        return moveX;
    }

    public void setMoveX(boolean moveX) {
        this.moveX = moveX;
    }

    public boolean isMoveY() {
        return moveY;
    }

    public void setMoveY(boolean moveY) {
        this.moveY = moveY;
    }
}
