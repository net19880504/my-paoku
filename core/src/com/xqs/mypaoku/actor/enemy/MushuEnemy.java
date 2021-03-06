package com.xqs.mypaoku.actor.enemy;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.xqs.mypaoku.MyPaokuGame;
import com.xqs.mypaoku.actor.Tower;
import com.xqs.mypaoku.actor.base.BaseEnemy;
import com.xqs.mypaoku.res.Res;
import com.xqs.mypaoku.util.TextureUtil;

/**
 * Created by Administrator on 2017/3/27 0027.
 */

public class MushuEnemy extends BaseEnemy {
    public final static String TAG="CaihuaEnemy";

    public final static int StartY=150;


    public MushuEnemy(MyPaokuGame mainGame) {
        super(mainGame);
        position.x=this.mainGame.getWorldWidth();
        position.y=StartY;

        setStopX(Tower.getStopX());

        setPosition(position.x,position.y);

        walk();
    }

    @Override
    public Animation getWalkAnimation() {
        TextureAtlas.AtlasRegion walkRegion=mainGame.getAtlas().findRegion(Res.Atlas.IMAGE_ENEMY_MUSHU_WALK);
        Animation walkAnimation = new  Animation(0.1F, TextureUtil.getTextureRegions(walkRegion,1,4));
        return walkAnimation;
    }

    @Override
    public Animation getFireAnimation() {
        TextureAtlas.AtlasRegion region=mainGame.getAtlas().findRegion(Res.Atlas.IMAGE_ENEMY_MUSHU_FIRE);
        Animation animation = new  Animation(0.08F, TextureUtil.getTextureRegions(region,1,7));
        return animation;
    }

    @Override
    public Animation getHurtAnimation() {
        TextureAtlas.AtlasRegion region=mainGame.getAtlas().findRegion(Res.Atlas.IMAGE_ENEMY_MUSHU_DEAD);
        Animation animation = new  Animation(0.08F, TextureUtil.getTextureRegions(region,1,6));
        return animation;
    }

    @Override
    public void orderAct(float delta, int counter) {
        if(counter%10==0) {
            if(getX()>getStopX()) {
                fire();
            }
        }
    }
}
