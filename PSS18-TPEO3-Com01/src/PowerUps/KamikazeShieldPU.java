package PowerUps;

import Assets.SpriteDepot;
import Collisions.*;
import Controllers.EnemyBehaviour;
import Controllers.PowerUpMovementController;
import Controllers.Sinusoidal;
import GameMaster.Timer;
import GameObjects.Player;
import GameObjects.Vector2;
import Map.Map;

public class KamikazeShieldPU extends AbstractPU {


    public KamikazeShieldPU(Vector2 v){
        controller = new PowerUpMovementController(this, new EnemyBehaviour(new Sinusoidal())); //TODO: crear movimientos de los power up
        health = 1;
        sprite = SpriteDepot.SHIELD;
        ubication = v;
        speed = 1;
        c = new PowerUpCollider(this);
        time = 5000;
        revert = new KamikazeReverter();
        Map.getInstance().add(this);




    }

    @Override
    public void trigger() {
        Collider c = new KamikazeShieldCollider(Player.getInstance());
        Player.getInstance().setCollider(c);

        Timer t = new Timer(time);
        new RevertKS(t, revert);

    }

    @Override
    public void destroySelf() {
        revert.run();
        super.destroySelf();

    }
}
