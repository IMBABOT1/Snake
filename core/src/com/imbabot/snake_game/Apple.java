package com.imbabot.snake_game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ParticleControllerInfluencer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;



public class Apple {


    private int cellX;
    private int cellY;
    private TextureRegion textureApple;

    private boolean isActive;
    private float offset;
    private int leftBorder;
    private int topBorder;

    public int getCellX() {
        return cellX;
    }

    public int getCellY() {
        return cellY;
    }


    public void setActive(boolean active) {
        isActive = active;
    }

    public Apple(TextureAtlas atlas){
        this.textureApple = atlas.findRegion("Apple");
        this.isActive = false;
        this.cellX = MathUtils.random(0, 10);
        this.cellX = MathUtils.random(0, 10);
        this.leftBorder = 30;
        this.topBorder = 780;
        this.offset = 40;
    }

    public void render(SpriteBatch batch){
        if (isActive) {
            batch.draw(textureApple, cellX * GameMap.CELL_SIZE, cellY * GameMap.CELL_SIZE);
        }else {
            cellX = MathUtils.random(0, 10);
            cellY = MathUtils.random(0, 10);
            isActive = true;
        }
    }

    public void update(float dt){
    }
}
