package com.imbabot.snake_game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

public class Snake {

    private Vector2 position;
    private Texture texture;
    private float speed;

    private boolean isPressedD;
    private boolean isPressedA;
    private boolean isPressedW;
    private boolean isPressedS;


    public Snake() {
        this.texture = new Texture("Snake.png");
        this.position = new Vector2(100, 100);
        this.speed = 300.0f;
        this.isPressedD = false;
        this.isPressedA = false;
        this.isPressedS = false;
        this.isPressedW = false;
    }

    public void update(float dt){
        movement(dt);
    }

    public void movement(float dt){
        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            if (isPressedA == false){
                isPressedD = true;
                isPressedS = false;
                isPressedW = false;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)){
            if (isPressedD == false){
                isPressedA = true;
                isPressedS = false;
                isPressedW = false;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            if (isPressedW == false){
                isPressedS = true;
                isPressedA = false;
                isPressedD = false;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)){
            if (isPressedS == false){
                isPressedW = true;
                isPressedA = false;
                isPressedD = false;
            }
        }
        if (isPressedA){
            position.x -= speed * dt;
        }
        if (isPressedD){
            position.x += speed * dt;
        }
        if (isPressedS){
            position.y -= speed * dt;
        }
        if (isPressedW){
            position.y += speed * dt;
        }
    }

    public void render(SpriteBatch batch){
        batch.draw(texture, position.x - 35, position.y - 35);
    }

}
