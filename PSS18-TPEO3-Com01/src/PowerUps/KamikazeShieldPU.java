package PowerUps;

import Assets.SpriteDepot;
import Collisions.*;
import Controllers.EnemyBehaviour;
import Controllers.PowerUpBehaviour;
import Controllers.PowerUpMovementController;
import Controllers.Sinusoidal;
import GameMaster.Timer;
import GameObjects.Player;
import GameObjects.Vector2;
import Map.Map;

public class KamikazeShieldPU extends AbstractPU {


    public KamikazeShieldPU(Vector2 v){
        ubication = v;
        controller = new PowerUpMovementController(this, new PowerUpBehaviour());
        health = 1;
        sprite = SpriteDepot.SHIELD;
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
    public void update(Map map) {
        if(health == 1){
            updatePosition(map);
            super.update(map);
        }
    }

    @Override
    public void destroySelf() {
        super.destroySelf();

    }
}
