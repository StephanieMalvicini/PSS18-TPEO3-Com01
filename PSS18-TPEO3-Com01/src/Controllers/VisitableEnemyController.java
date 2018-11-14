package Controllers;

import Collisions.PowerUpVisitor;

public interface VisitableEnemyController {
    //Solo para el comportamiento de los power ups

    void accept(PowerUpVisitor v);

    void Freeze();

    void Unfreeze();

}
