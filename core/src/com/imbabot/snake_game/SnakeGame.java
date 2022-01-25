package com.imbabot.snake_game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class SnakeGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Snake snake;
	private TextureAtlas atlas;
	private BitmapFont bitmapFont;
	private GameMap gameMap;
	private Apple apple;

	@Override
	public void create () {
		this.atlas = new TextureAtlas("game.pack");
		this.batch = new SpriteBatch();
		this.snake = new Snake(atlas, this);
		this.bitmapFont = new BitmapFont(Gdx.files.internal("font32.fnt"));
		this.apple = new Apple(atlas);
		this.gameMap = new GameMap(atlas);
	}

	@Override
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		update(dt);
		ScreenUtils.clear(1, 1, 1, 0);
		batch.begin();
		gameMap.render(batch);
		apple.render(batch);
		snake.render(batch);
		snake.renderGUI(batch, bitmapFont);
		batch.end();
	}

	public Apple getApple() {
		return apple;
	}


	public void update(float dt){
		gameMap.update(dt);
		snake.update(dt);
		apple.update(dt);
	}

	@Override
	public void dispose () {
		batch.dispose();
		atlas.dispose();
	}
}
