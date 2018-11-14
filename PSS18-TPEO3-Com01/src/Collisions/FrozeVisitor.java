package Collisions;

import Controllers.VisitableEnemyController;

public class FrozeVisitor extends PowerUpVisitor{

    public FrozeVisitor(){}

    public void visitEnemyController(VisitableEnemyController e) {
        e.Freeze();
    }

}
