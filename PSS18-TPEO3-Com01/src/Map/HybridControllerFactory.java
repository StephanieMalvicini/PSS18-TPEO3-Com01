package Map;

import Controllers.EnemyMovementController;
import Controllers.HybridMovementEnemyMovementController;
import GameObjects.GameObject;

public class HybridControllerFactory extends AbstractControllerFactory {
    public HybridControllerFactory() {
    }

    @Override
    public EnemyMovementController createController(GameObject pos) {
        return new HybridMovementEnemyMovementController(pos);
    }
}
