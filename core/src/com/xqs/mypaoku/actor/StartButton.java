package com.xqs.mypaoku.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.xqs.mypaoku.MyPaokuGame;
import com.xqs.mypaoku.actor.base.BaseImageActor;

/**
 * Created by Administrator on 2017/4/10 0010.
 */

public class StartButton extends Button {
    public static final String BTN_UP="btn_start_default.png";
    public static final String BTN_DOWN="btn_start_pressed.png";

    public static final int MARGIN = 100;

    private Texture upTexture;
    private Texture downTexture;

    private MyPaokuGame mainGame;

    public StartButton(MyPaokuGame mainGame) {
        this.mainGame = mainGame;

        upTexture = new Texture(Gdx.files.internal(BTN_UP));
        downTexture = new Texture(Gdx.files.internal(BTN_DOWN));

        Button.ButtonStyle style = new Button.ButtonStyle();
        style.up = new TextureRegionDrawable(new TextureRegion(upTexture));
        style.down = new TextureRegionDrawable(new TextureRegion(downTexture));

        setStyle(style);

        setWidth(upTexture.getWidth());
        setHeight(upTexture.getHeight());

        float px = mainGame.getWorldWidth()/2 - upTexture.getWidth()/2;
        float py = mainGame.getWorldHeight() - upTexture.getHeight() - MARGIN;

        setPosition(px,py);
    }
}