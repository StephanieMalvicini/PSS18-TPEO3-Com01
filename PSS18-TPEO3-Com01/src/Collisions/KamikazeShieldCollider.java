package Collisions;

import GameObjects.DestroyableObject;

public class KamikazeShieldCollider extends Collider {


    public KamikazeShieldCollider(DestroyableObject o) {
        super(o);
        v = new KamikazeShieldVisitor();
    }

    @Override
    public void accept(Visitor v) {
        v.visitKamikazeShield(this);
    }
}
