package fr.gilles.breaker.blocks;

import java.awt.*;
import java.awt.geom.Point2D;

public class PlayerBlock extends GameBlock{

    public PlayerBlock(Point2D position, Color color){
        super(position, new Dimension(100, 15), color);
    }
}
