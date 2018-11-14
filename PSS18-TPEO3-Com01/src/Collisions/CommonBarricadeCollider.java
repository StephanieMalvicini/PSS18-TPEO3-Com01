package Collisions;

import GameObjects.CommonBarricade;

public class CommonBarricadeCollider extends Collider {

    public CommonBarricadeCollider(CommonBarricade commonBarricade) {
        super(commonBarricade);
        v = new CommonBarricadeVisitor();
    }

    @Override
    public void accept(Visitor v) {
        v.visitCommonBarricade(this);
    }

    public void update(){
        super.update();
        scanCollisions();
        solveCollision();
    }

}
