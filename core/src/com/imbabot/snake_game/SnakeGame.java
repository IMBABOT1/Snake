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
	private TextureAtlas atlas;
	private BitmapFont bitmapFont;
	private GameController gc;

	@Override
	public void create () {
		this.atlas = new TextureAtlas("game.pack");
		this.batch = new SpriteBatch();
		this.bitmapFont = new BitmapFont(Gdx.files.internal("font32.fnt"));
		this.gc = new GameController(atlas);
	}

	@Override
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		update(dt);
		ScreenUtils.clear(1, 1, 1, 0);
		batch.begin();
		gc.getGameMap().render(batch);
		gc.getApple().render(batch);
		gc.getSnake().render(batch);
		gc.getSnake().renderGUI(batch, bitmapFont);
		batch.end();
	}


	public void update(float dt){
		gc.update(dt);
	}

	@Override
	public void dispose () {
		batch.dispose();
		atlas.dispose();
	}
}
