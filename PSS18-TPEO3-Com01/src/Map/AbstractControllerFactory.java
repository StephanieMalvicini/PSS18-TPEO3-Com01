package Map;

import Controllers.EnemyMovementController;
import GameObjects.GameObject;

public abstract class AbstractControllerFactory {

    public abstract EnemyMovementController createController(GameObject pos);
}
