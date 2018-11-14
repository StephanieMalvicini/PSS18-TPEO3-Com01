package Controllers;

import GameObjects.GameObject;
import GameObjects.KamikazeEnemy;

public class KamikazeMovementEnemyMovementController<E extends KamikazeEnemy> extends EnemyMovementController<E> {

    public KamikazeMovementEnemyMovementController(GameObject pos) {
        super();
        controlled = (E) new KamikazeEnemy();
        b = new FollowBehaviour(controlled,pos);
    }

    public void activate(){
        setBehaviour(new DizzyBehaviour());
    }

    public void setBehaviour(Behaviour be){
        b = be;
    }
}
