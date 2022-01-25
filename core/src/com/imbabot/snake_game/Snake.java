package com.imbabot.snake_game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;


public class Snake {


    private int rightBorder;
    private int leftBorder;
    private int top;
    private int bottom;


    private float cellX;
    private float cellY;
    private TextureRegion texture;
    private float speed;

    private boolean isPressedD;
    private boolean isPressedA;
    private boolean isPressedW;
    private boolean isPressedS;

    private float offset;
    private StringBuilder stringBuilder;
    private int score;

    private GameController game;


    public Snake(TextureAtlas atlas, GameController game) {
        this.game = game;
        this.cellX = 1;
        this.cellY = 1;
        this.speed = 5f;
        this.isPressedD = false;
        this.isPressedA = false;
        this.isPressedS = false;
        this.isPressedW = false;
        this.offset = 40;
        this.texture = atlas.findRegion("Snake");
        this.stringBuilder = new StringBuilder();
        this.score = 0;
        this.leftBorder = 0;
        this.rightBorder = 9;
        this.top = 9;
        this.bottom = 0;

    }

    public void update(float dt){
        movement(dt);
        checkBounds();
    }

    private void checkBounds() {
        if (cellX > rightBorder) {
            cellX = rightBorder;
        }
        if (cellX < leftBorder) {
            cellX = leftBorder;
        }
        if (cellY > top) {
            cellY = top;
        }
        if (cellY < bottom) {
            cellY = bottom;
        }
    }




    public void movement(float dt){
        eatApple();
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
            cellX -= speed * dt;
        }
        if (isPressedD){
            cellX += speed * dt;
        }
        if (isPressedS){
            cellY -= speed * dt;
        }
        if (isPressedW){
            cellY += speed * dt;
        }
    }


    private void addScore(int amount){
        score += amount;
    }

    private void eatApple(){
//        if (position.dst(game.getApple().getPosition()) < 50){
//            game.getApple().setActive(false);
//            addScore(10);
//        }
    }

    public void renderGUI(SpriteBatch batch, BitmapFont font){
        stringBuilder.setLength(0);
        stringBuilder.append("Score: " + score);
        font.draw(batch, stringBuilder, 10, 790);
    }
    public void render(SpriteBatch batch){
        batch.draw(texture, cellX * GameMap.CELL_SIZE, cellY * GameMap.CELL_SIZE);
    }
}
