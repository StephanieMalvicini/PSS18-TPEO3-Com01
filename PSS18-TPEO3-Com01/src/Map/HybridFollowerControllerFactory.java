package Map;

import Controllers.EnemyMovementController;
import Controllers.HybridFollowerMovementEnemyMovementController;
import GameObjects.GameObject;

public class HybridFollowerControllerFactory extends AbstractControllerFactory{

    public HybridFollowerControllerFactory() {
    }

    @Override
    public EnemyMovementController createController(GameObject pos) {
        return new HybridFollowerMovementEnemyMovementController(pos);
    }
}
