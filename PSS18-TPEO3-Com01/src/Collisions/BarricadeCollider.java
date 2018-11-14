package Collisions;

import GameObjects.EnemyBarricade;

public class BarricadeCollider extends Collider {

    public BarricadeCollider(EnemyBarricade c){
        super(c);
        v = new EnemyBarricadeVisitor();
    }


    @Override
    public void accept(Visitor v) {
        v.visitBarricade(this);
    }

    public void update(){
        super.update();
        scanCollisions();
        solveCollision();


    }
}
