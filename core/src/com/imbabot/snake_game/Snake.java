package com.imbabot.snake_game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class Snake {

    private Vector2 position;
    private Texture texture;
    private float speed;

    private boolean isPressedD;
    private boolean isPressedA;
    private boolean isPressedW;
    private boolean isPressedS;

    private float offset;
    private StringBuilder stringBuilder;


    public Snake() {
        this.texture = new Texture("Snake.png");
        this.position = new Vector2(100, 100);
        this.speed = 300.0f;
        this.isPressedD = false;
        this.isPressedA = false;
        this.isPressedS = false;
        this.isPressedW = false;
        this.offset = 36;
        this.stringBuilder = new StringBuilder();
    }

    public void update(float dt){
        movement(dt);
        checkBounds();
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

    private void checkBounds(){
        if (position.x > 800 - offset){
            position.x = 800 - offset;
        }
        if (position.x < 0 + offset){
            position.x = 0 + offset;
        }
        if (position.y > 800 - offset){
            position.y = 800 - offset;
        }
        if (position.y < 0 + offset){
            position.y = 0 + offset;
        }

    }

    public void renderGUI(SpriteBatch batch, BitmapFont font){
        stringBuilder.setLength(0);
        stringBuilder.append("Score: ");
        font.draw(batch, stringBuilder, 10, 790);
    }
    public void render(SpriteBatch batch){
        batch.draw(texture, position.x - offset, position.y - offset);
    }

}
