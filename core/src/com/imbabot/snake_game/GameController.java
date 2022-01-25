package com.imbabot.snake_game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class GameController {
    private Snake snake;
    private GameMap gameMap;
    private Apple apple;


    public GameController(TextureAtlas atlas){
        this.apple = new Apple(atlas);
        this.gameMap = new GameMap(atlas);
        this.snake = new Snake(atlas, this);
    }

    public Snake getSnake() {
        return snake;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public Apple getApple() {
        return apple;
    }

    public void update(float dt){
        gameMap.update(dt);
        snake.update(dt);
        apple.update(dt);
    }
}
