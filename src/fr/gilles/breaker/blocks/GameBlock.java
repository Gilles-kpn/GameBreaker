package fr.gilles.breaker.blocks;

import java.awt.*;
import java.awt.geom.Point2D;

public class GameBlock {

    protected Point2D position;

    protected Dimension dimension;

    protected Color color;

    public GameBlock(Point2D position, Dimension dimension, Color color) {
        this.position = position;
        this.dimension = dimension;
        this.color = color;
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
