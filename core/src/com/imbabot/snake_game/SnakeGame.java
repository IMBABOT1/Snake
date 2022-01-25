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
	private TextureRegion textureGrass;

	@Override
	public void create () {
		this.atlas = new TextureAtlas("game.pack");
		this.batch = new SpriteBatch();
		this.snake = new Snake(atlas);
		this.textureGrass = atlas.findRegion("grass");
		this.bitmapFont = new BitmapFont(Gdx.files.internal("font32.fnt"));
	}

	@Override
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		update(dt);
		ScreenUtils.clear(1, 1, 1, 0);
		batch.begin();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10 ; j++) {
				batch.draw(textureGrass, i * 80, j * 80);
			}
		}
		snake.render(batch);
		snake.renderGUI(batch, bitmapFont);
		batch.end();
	}

	public void update(float dt){
		snake.update(dt);
	}

	@Override
	public void dispose () {
		batch.dispose();


	}
}
