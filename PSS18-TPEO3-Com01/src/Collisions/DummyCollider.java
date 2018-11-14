package Collisions;

import GameObjects.DestroyableObject;

//Collider que no hace nada

public class DummyCollider extends Collider {

    public DummyCollider(DestroyableObject o) {
        super(o);
        v = new DummyVisitor();
    }

    @Override
    public void accept(Visitor v) {

    }
}
