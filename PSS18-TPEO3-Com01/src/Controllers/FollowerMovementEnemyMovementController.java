package Controllers;

import GameObjects.FollowerEnemy;
import GameObjects.GameObject;
import GameObjects.Player;

public class FollowerMovementEnemyMovementController<E extends FollowerEnemy> extends EnemyMovementController<E> {

    public FollowerMovementEnemyMovementController(GameObject pos) {
        super();
        controlled = (E) new FollowerEnemy();
        b = new FollowBehaviour(controlled, pos);
    }

    public void activate(){
        setBehaviour(new FollowBehaviour(controlled, Player.getInstance()));
    }

    public void setBehaviour(Behaviour be){
        b = be;
    }
}
