package com.mkemp.simpleanimation;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SimpleAnimation extends ApplicationAdapter implements InputProcessor {

	private SpriteBatch batch;
	private TextureAtlas textureAtlas;
	private Animation<TextureRegion> animation;
	private float ellapsedTime = 0;

	private Animation<TextureRegion> rotateUpAnimation;
	private Animation<TextureRegion> rotateDownAnimation;

	@Override
	public void create () {
		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas("spritesheet.atlas");

		animation = new Animation<TextureRegion>(1/15f, textureAtlas.getRegions());

		TextureRegion[] rotateUpFrames = new TextureRegion[10];

		rotateUpFrames[0] = (textureAtlas.findRegion("0001"));
		rotateUpFrames[1] = (textureAtlas.findRegion("0002"));
		rotateUpFrames[2] = (textureAtlas.findRegion("0003"));
		rotateUpFrames[3] = (textureAtlas.findRegion("0004"));
		rotateUpFrames[4] = (textureAtlas.findRegion("0005"));
		rotateUpFrames[5] = (textureAtlas.findRegion("0006"));
		rotateUpFrames[6] = (textureAtlas.findRegion("0007"));
		rotateUpFrames[7] = (textureAtlas.findRegion("0008"));
		rotateUpFrames[8] = (textureAtlas.findRegion("0009"));
		rotateUpFrames[9] = (textureAtlas.findRegion("00010"));

		rotateUpAnimation = new Animation<TextureRegion>(0.1f, rotateUpFrames);
		rotateDownAnimation = new Animation<TextureRegion>(0.1f,
				(textureAtlas.findRegion("0011")),
				(textureAtlas.findRegion("0012")),
				(textureAtlas.findRegion("0013")),
				(textureAtlas.findRegion("0014")),
				(textureAtlas.findRegion("0015")),
				(textureAtlas.findRegion("0016")),
				(textureAtlas.findRegion("0017")),
				(textureAtlas.findRegion("0018")),
				(textureAtlas.findRegion("0019")),
				(textureAtlas.findRegion("0020")));

		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		ellapsedTime += Gdx.graphics.getDeltaTime();
		batch.draw(animation.getKeyFrame(ellapsedTime, true), 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		textureAtlas.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
