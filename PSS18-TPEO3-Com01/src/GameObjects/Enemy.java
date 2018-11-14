package GameObjects;

import Assets.SpriteDepot;
import GUI.ScoreManager;

public abstract class Enemy extends Ship {

    protected int score;
    protected float Speed;
    protected float kamikazeDamage;
    protected int lvl;

    public void destroySelf(){  //TODO: Cada destroy debria nullificar los atributos añadidos en su subclase y llamar a el super
        ScoreManager.getInstance().modificarScore(score);
        sprite = SpriteDepot.EXPLOSION;
        c.destroySelf();
    }

    public void damage(float d){
        health -= d;
        System.out.println(health);
    }



    public float getKamikazeDamage() {
        return kamikazeDamage;
    }
}
