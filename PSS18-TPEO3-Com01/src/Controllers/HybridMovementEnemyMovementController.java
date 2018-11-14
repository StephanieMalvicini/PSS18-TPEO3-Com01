package Controllers;

import GameObjects.EnemyFighterHybrid;
import GameObjects.GameObject;
import Map.Map;

public class HybridMovementEnemyMovementController<E extends EnemyFighterHybrid> extends EnemyMovementController<E> {

    private float health;

    public HybridMovementEnemyMovementController(GameObject pos) {
        super();
        controlled = (E) new EnemyFighterHybrid();
        health = controlled.getHealth();
        b = new FollowBehaviour(controlled, pos);
    }

    @Override
    public void setBehaviour(Behaviour be) {
        b = be;
    }

    @Override
    public void activate() {
    }

    @Override
    public void update(Map map) {

        if(controlled.getHealth()<=health*0.2)
            b = new DizzyBehaviour();
        super.update(map);
    }
}
