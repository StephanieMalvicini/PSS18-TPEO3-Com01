package PowerUps;

import Assets.SpriteDepot;
import Collisions.FrozeVisitor;
import Collisions.PowerUpCollider;
import Collisions.Visitor;
import Controllers.EnemyBehaviour;
import Controllers.PowerUpMovementController;
import Controllers.Sinusoidal;
import GameMaster.Timer;
import GameObjects.Vector2;
import Map.Map;

public class FrozePU extends AbstractPU {
    Visitor v;


    public FrozePU(Vector2 dir){
        controller = new PowerUpMovementController(this, new EnemyBehaviour(new Sinusoidal())); //TODO: crear movimientos de los power up
        health = 1;
        sprite = SpriteDepot.FROZE;
        Vector2 n = new Vector2(dir.getX(), dir.getY());
        ubication = n;
        speed = 1;
        v = new FrozeVisitor();
        revert = new FrozenReverter();
        c = new PowerUpCollider(this);
        Map.getInstance().add(this);



    }

    @Override
    public void trigger() {
        Map.getInstance().getFormation().affect(v); //TODO: crear nueva instancia de visitor
        Timer t = new Timer(2000);
        new RevertFrozen(t, revert);

    }


}
