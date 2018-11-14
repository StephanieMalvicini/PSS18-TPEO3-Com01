package Collisions;

import GameObjects.EnemyBarricade;

public class EnemyBarricadeCollider extends Collider {

    public EnemyBarricadeCollider(EnemyBarricade c){
        super(c);
        v = new EnemyBarricadeVisitor();
    }


    @Override
    public void accept(Visitor v) {
        v.visitEnemyBarricade(this);
    }

    public void update(){
        super.update();
        scanCollisions();
        solveCollision();
    }
}
