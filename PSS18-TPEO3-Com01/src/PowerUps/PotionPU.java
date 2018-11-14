package PowerUps;

import Assets.SpriteDepot;
import Collisions.FrozeVisitor;
import Collisions.PowerUpCollider;
import Controllers.PowerUpBehaviour;
import Controllers.PowerUpMovementController;
import GameObjects.Player;
import GameObjects.Vector2;
import Map.Map;

public class PotionPU extends AbstractPU {

    public PotionPU(Vector2 dir){
        controller = new PowerUpMovementController(this, new PowerUpBehaviour());
        health = 1;
        sprite = SpriteDepot.POTION;
        ubication = dir;
        speed = 1;
        c = new PowerUpCollider(this);
        Map.getInstance().add(this);
    }

    @Override
    public void trigger() {
        Player.getInstance().setHealth(200);
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
