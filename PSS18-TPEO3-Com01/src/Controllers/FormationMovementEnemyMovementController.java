package Controllers;

import Map.Formation;

public class FormationMovementEnemyMovementController extends EnemyMovementController {
    public FormationMovementEnemyMovementController(Formation f) {
        controlled = f;
        b = new FormationBehaviour();
    }

    @Override
    public void setBehaviour(Behaviour be) {
    }

    @Override
    public void activate() {
    }
}
