package GameObjects;

import Assets.SpriteDepot;
import Collisions.EnemyCollider;
import Map.Map;

public class EnemyFighterHybrid extends EnemyFighter{

    protected float enemyHealth;

    public EnemyFighterHybrid(){
        enemyHealth = 200 * (0.3f * lvl);
        health = enemyHealth;
        Speed = 0.1f;
        speed = Speed;
        time=0;
        ubication = posInicial;
        dir = Vector2.ORIGIN();
        damage = 20 + 0.8f * lvl;
        kamikazeDamage = 30 + 12*lvl;
        sprite = SpriteDepot.SHOOTERHYBRID;
        attackSpeed = fighterAttackSpeed;
        loaded = true;
        gunPosition = -7;
        gunPhaseShift = 40;
        c = new EnemyCollider(this, kamikazeDamage);
        score = 150 +25 * lvl;
        Map.getInstance().add(this);
    }

    public void update(Map map) {
        if (isAlive()) {
            updatePosition(map);
            super.update(map);
        } else {
            destroySelf();
            destroyMe(map);
        }

    }


}
