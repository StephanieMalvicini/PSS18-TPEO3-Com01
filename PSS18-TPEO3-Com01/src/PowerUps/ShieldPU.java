package PowerUps;

import Assets.SpriteDepot;
import Collisions.PowerUpCollider;
import Controllers.BasicMovementController;
import Controllers.EnemyBehaviour;
import Controllers.Sinusoidal;
import GameObjects.Player;
import GameObjects.Vector2;

public class ShieldPU extends AbstractPU {
    int power;

    public ShieldPU(Vector2 dir){
        controller = new BasicMovementController(this, new EnemyBehaviour(new Sinusoidal()));
        c = new PowerUpCollider(this);
        health = 1;
        sprite = SpriteDepot.SHIELD;
        ubication = dir;
        speed = 1;
        power = 50;




    }

    @Override
    public void trigger() {
        Player.getInstance().getShield().add(power);

    }
}
