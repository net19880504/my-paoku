package com.xqs.mypaoku.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.xqs.mypaoku.MyPaokuGame;
import com.xqs.mypaoku.actor.menu.MenuBg;
import com.xqs.mypaoku.actor.menu.QuitButton;
import com.xqs.mypaoku.actor.menu.SoundButton;
import com.xqs.mypaoku.actor.menu.StartButton;
import com.xqs.mypaoku.stage.base.BaseStage;

/**
 * Created by Administrator on 2017/4/8 0008.
 */

public class MenuStage extends BaseStage {
    public static final String TAG = "MenuStage";

    private MenuBg menuBg;
    private SoundButton soundButton;
    private StartButton startButton;
    private QuitButton quitButton;


    public MenuStage(final MyPaokuGame mainGame, Viewport viewport) {
        super(mainGame, viewport);

        // bg
        menuBg = new MenuBg(mainGame);
        addActor(menuBg);

        // sound btn
        soundButton = new SoundButton(mainGame);
        addActor(soundButton);

        // start btn
        startButton = new StartButton(mainGame);
        addActor(startButton);

        // quit btn
        quitButton = new QuitButton(mainGame);
        addActor(quitButton);

        // set listeners
        soundButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                soundButton.press();
            }
        });

        startButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                mainGame.showLevelScreen();
            }
        });

        quitButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                quitButton.setChecked(true);
//                mainGame.dispose();
                Gdx.app.exit();
            }
        });

    }

    @Override
    public void orderAct(float delta, int counter) {
    }


}
