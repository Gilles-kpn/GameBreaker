package fr.gilles.breaker.blocks;

import fr.gilles.breaker.game.Settings;

import java.awt.*;
import java.awt.geom.Point2D;

public class ObstaclesBlocks extends  GameBlock{
    private TargetBlock[][] targetBlocks;

    public ObstaclesBlocks(Point2D position, Dimension dimension, Color color) {
        super(position, dimension, color);
        findColumnsSize();
        init();
    }

    private void findColumnsSize(){
        int ny = dimension.height / (Settings.getSettings().dimension.height +7);
        int nx = dimension.width / (Settings.getSettings().dimension.width +7);
        targetBlocks = new TargetBlock[nx][ny];
    }

    private void init(){
        for (int i=0; i < targetBlocks.length ;i++){
            for (int y=0; y< targetBlocks[0].length; y++){
                targetBlocks[i][y] = new TargetBlock(
                        new Point2D.Double(
                                i*(Settings.getSettings().dimension.width+1)+getPosition().getX(),
                                y*( Settings.getSettings().dimension.height +1)+getPosition().getY()
                        ),
                        new Dimension(
                                Settings.getSettings().dimension.width,
                                Settings.getSettings().dimension.height
                        ),
                        Color.green
                );
            }

        }
    }

    public TargetBlock[][] getTargetBlocks() {
        return targetBlocks;
    }

    public void setTargetBlocks(TargetBlock[][] targetBlocks) {
        this.targetBlocks = targetBlocks;
    }
}
