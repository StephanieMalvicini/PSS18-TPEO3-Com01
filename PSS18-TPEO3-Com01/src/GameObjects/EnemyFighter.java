package GameObjects;

import Assets.SpriteDepot;
import Controllers.FighterFireController;
import GUI.ScoreManager;
import Map.Map;
import PowerUps.AbstractPU;
import PowerUps.FrozePU;
import PowerUps.KamikazeShieldPU;
import PowerUps.PierceBulletPU;

import javax.swing.*;

public abstract class EnemyFighter extends Enemy {



    protected int damage;
    protected int attackSpeed;
    protected boolean loaded;
    protected long time;
    protected int gunPosition;
    protected static Vector2 initialPosition = new Vector2(400,00);
    protected static int fighterAttackSpeed = 300;
    protected float gunPhaseShift;
    protected FighterFireController f;



    public void destroySelf(){  //TODO: Cada destroy debria nullificar los atributos añadidos en su subclase y llamar a el super
        ScoreManager.getInstance().modificarScore(score);
        sprite = SpriteDepot.EXPLOSION;
        new KamikazeShieldPU(ubication);
        c.destroySelf();
        Map.getInstance().destroy(this);
        sprite = new ImageIcon();

    }




    protected void checkFire(Map map) {

        if (time < System.currentTimeMillis())
            loaded = true;
        if (loaded && isFiring){
            loaded = false;
            time = System.currentTimeMillis() + attackSpeed;


            Vector2 ubBullet = getUbication().sum(Vector2.RIGHT(gunPosition+gunPhaseShift));
            Bullet b = new EnemyFighterBullet(damage,ubBullet);
            map.add(b);
            gunPhaseShift *= -1;

        }

    }

    public void damage(float d){
        health -= d;

    }

}
