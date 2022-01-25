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

    private Vector2 position;
    private TextureRegion textureApple;

    private boolean isActive;
    private float offset;
    private int leftBorder;
    private int topBorder;


    public Vector2 getPosition() {
        return position;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Apple(TextureAtlas atlas){
        this.textureApple = atlas.findRegion("Apple");
        this.isActive = false;
        this.position = new Vector2(0, 0);
        this.leftBorder = 30;
        this.topBorder = 780;
        this.position.x = MathUtils.random(leftBorder, topBorder);
        this.position.y = MathUtils.random(leftBorder, topBorder);
        this.offset = 40;
    }

    public void render(SpriteBatch batch){
        if (isActive) {
            batch.draw(textureApple, position.x - offset, position.y - offset);
        }else {
            position.x = MathUtils.random(leftBorder, topBorder);
            position.y = MathUtils.random(leftBorder, topBorder);
            isActive = true;
        }
    }

    public void update(float dt){
    }
}
