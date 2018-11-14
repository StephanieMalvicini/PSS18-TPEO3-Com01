package Collisions;


import GameObjects.Enemy;

public class EnemyCollider extends Collider {
    protected float daño;

    public EnemyCollider(Enemy o, float d) {
        super(o);
        daño = d;
        v = new EnemyVisitor(daño);
    }



    @Override
    public void accept(Visitor v) {
        v.visitEnemy(this);
    }


}
