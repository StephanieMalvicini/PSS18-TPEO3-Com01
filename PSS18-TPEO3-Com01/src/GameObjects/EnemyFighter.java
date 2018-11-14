package GameObjects;


public abstract class EnemyFighter extends Enemy{



    protected float damage;
    protected int attackSpeed;
    protected boolean loaded;
    protected long time;
    protected int gunPosition;
    protected static int fighterAttackSpeed = 800;
    protected float gunPhaseShift;



    public void destroySelf(){
        super.destroySelf();
    }

    public void fire() {

        if (time < System.currentTimeMillis())
            loaded = true;
        if (loaded){
            loaded = false;
            time = System.currentTimeMillis() + attackSpeed;
            Vector2 ubBullet = getUbication().sum(Vector2.RIGHT(gunPosition+gunPhaseShift));
            new EnemyFighterBullet(damage,ubBullet);
            gunPhaseShift *= -1;

        }

    }

    public void damage(float d){
        health -= d;

    }

}
