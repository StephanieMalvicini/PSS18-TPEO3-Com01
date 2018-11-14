package Collisions;

import GameObjects.DestroyableObject;
import PowerUps.AbstractPU;

public class PowerUpCollider extends Collider {

    public PowerUpCollider(AbstractPU o) {
        super(o);
        v = new PowerUpVisitor();
    }

    @Override
    public void accept(Visitor v) {
        v.visitPowerUp(this);

    }

    public void trigger(){
        ((AbstractPU) o).trigger();
    }
}
