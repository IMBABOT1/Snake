package com.imbabot.snake_game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameMap {

    public static final int CELLS_X = 10;
    public static final int CELLS_Y = 10;
    public static final int CELL_SIZE = 80;


    public int getCellsX() {
        return CELLS_X - 1;
    }

    public int getCellsY() {
        return CELLS_Y - 1;
    }

    private TextureRegion grassTexture;

    public GameMap(TextureAtlas atlas){
        this.grassTexture = atlas.findRegion("grass");
    }

    public void render(SpriteBatch batch){
        for (int i = 0; i < CELLS_X; i++) {
            for (int j = 0; j < CELLS_Y; j++) {
                batch.draw(grassTexture, i * CELL_SIZE, j * CELL_SIZE);
            }
        }
    }

    public void update(float dt){

    }
}
