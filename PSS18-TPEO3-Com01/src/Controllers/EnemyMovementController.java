package Controllers;

import Collisions.PowerUpVisitor;
import GameObjects.Enemy;
import Map.Map;

public abstract class EnemyMovementController<E extends Enemy> extends MovementController<E> implements VisitableEnemyController {




    public EnemyMovementController(){
        Map.getInstance().add(this);
    }

    @Override
    public void update(Map map)
    {
        if (controlled.isAlive()) {
            super.update(map);


        }
        else
            destroyMe(map);
    }

    @Override
    public void destroyMe(Map map) {
        Map.getInstance().getFormation().removeCont(this);
        super.destroyMe(map);
    }

    public abstract void activate();

    public abstract void setBehaviour(Behaviour be);

    public void accept(PowerUpVisitor v){
        v.visitEnemyController(this);
    }

    public void Freeze() {
        b.pause();
    }

    public void Unfreeze(){
        b.unpause();
    }


    public boolean isFrozen() {
        return b.isPaused();
    }
}
