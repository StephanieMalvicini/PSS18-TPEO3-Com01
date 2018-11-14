package Collisions;

import GameObjects.Bullet;
import GameObjects.EnemyBullet;

import java.util.Collection;
import java.util.HashSet;

public class EnemyBulletCollider extends Collider {

    Collection<Collider> collided;

    public EnemyBulletCollider(EnemyBullet o) {
        super(o);
        v = new EnemyBulletVisitor(o.getDaño());
        collided = new HashSet<>();
    }

    @Override
    public void accept(Visitor v) {
        v.visitEnemyBullet(this);
    }

    protected void solveCollision() {
        for(Collider c : collisions){
            if(!collided.contains(c)) {
                c.accept(v);
                collided.add(c);
            }

        }

    }
    @Override


    public void update(){
        super.update();
        scanCollisions();
        solveCollision();


    }
}
