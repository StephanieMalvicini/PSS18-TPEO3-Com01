package Controllers;

import GUI.IUpdatable;
import GameObjects.EnemyFighter;
import GameObjects.Ship;

public abstract class IFireController implements IController {

    EnemyFighter controlled;

    public abstract void Fire();


    public abstract void endFire();
}
