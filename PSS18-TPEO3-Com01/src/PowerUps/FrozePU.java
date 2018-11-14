package PowerUps;

import Assets.SpriteDepot;
import Collisions.FrozeVisitor;
import Collisions.PowerUpCollider;
import Collisions.PowerUpVisitor;
import Collisions.Visitor;
import Controllers.EnemyBehaviour;
import Controllers.PowerUpBehaviour;
import Controllers.PowerUpMovementController;
import Controllers.Sinusoidal;
import GameMaster.Timer;
import GameObjects.Vector2;
import Map.Map;

public class FrozePU extends AbstractPU {
    protected PowerUpVisitor frozev;


    public FrozePU(Vector2 dir){
        controller = new PowerUpMovementController(this, new PowerUpBehaviour());
        health = 1;
        sprite = SpriteDepot.FROZE;
        ubication = dir;
        speed = 1;
        frozev = new FrozeVisitor();
        revert = new FrozenReverter();
        c = new PowerUpCollider(this);
        Map.getInstance().add(this);
    }

    @Override
    public void trigger() {
        Map.getInstance().getFormation().affectPowerUp(frozev);
        Timer t = new Timer(2000);
        new RevertFrozen(t, revert);

    }

    @Override
    public void update(Map map) {
        if(health == 1){
            updatePosition(map);
            super.update(map);
        }
        else
            destroySelf();
    }

    @Override
    public void destroySelf() {
        super.destroySelf();
    }
}
