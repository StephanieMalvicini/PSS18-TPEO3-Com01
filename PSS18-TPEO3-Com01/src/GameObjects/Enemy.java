package GameObjects;

import Assets.SpriteDepot;
import GUI.ScoreManager;
import Map.Map;
import PowerUps.PowerUpPool;

import java.util.Random;

public abstract class Enemy extends Ship {

    protected int score;
    protected float Speed;
    protected float kamikazeDamage;
    protected int lvl = Map.getInstance().getLevel();
    protected Vector2 posInicial = new Vector2(400, 2900);

    public void destroySelf(){
        ScoreManager.getInstance().modificarScore(score);
        Random rand = new Random();
        float aux = rand.nextFloat();
        int aux2;
        if (aux<0.35){
            aux2 = rand.nextInt(PowerUpPool.getInstance().getPool().size());
            PowerUpPool.getInstance().getPool().get(aux2).newPowerUp(ubication);
        }
        c.destroySelf();
        sprite = SpriteDepot.EXPLOSION;
        Map.getInstance().destroy(this);
    }

    public void damage(float d){
        health -= d;
    }
}
