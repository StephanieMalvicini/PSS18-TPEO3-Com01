package Map;

import Controllers.EnemyMovementController;
import Controllers.FighterMovementEnemyMovementController;
import GameObjects.GameObject;

public class FighterControllerFactory extends AbstractControllerFactory {

    public FighterControllerFactory(){}

    @Override
    public EnemyMovementController createController(GameObject pos) {
        return new FighterMovementEnemyMovementController(pos);
    }
}
