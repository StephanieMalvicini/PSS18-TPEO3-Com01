package Map;

import Controllers.EnemyMovementController;
import Controllers.KamikazeMovementEnemyMovementController;
import GameObjects.GameObject;

public class KamikazeControllerFactory extends AbstractControllerFactory {
    public KamikazeControllerFactory() {
    }

    @Override
    public EnemyMovementController createController(GameObject pos) {
        return new KamikazeMovementEnemyMovementController(pos);
    }
}
