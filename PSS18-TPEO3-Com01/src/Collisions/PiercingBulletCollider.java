package Collisions;

import GameObjects.PiercingBullet;

import java.util.Collection;
import java.util.HashSet;

public class PiercingBulletCollider extends Collider {

    Collection<Collider> collided;
    public PiercingBulletCollider(PiercingBullet o) {
        super(o);
        v = new PiercingBulletVisitor(o.getDaño());
        collided = new HashSet<>();
    }

    @Override
    public void accept(Visitor v) {
        v.visitPiercingBullet(this);
    }

    protected void solveCollision() {
        for(Collider c : collisions){
            if(!collided.contains(c)) {
                c.accept(v);
                collided.add(c);
            }

        }

    }
}
