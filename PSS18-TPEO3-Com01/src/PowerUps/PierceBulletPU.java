package PowerUps;

import Assets.SpriteDepot;
import Collisions.PowerUpCollider;
import Controllers.EnemyBehaviour;
import Controllers.PowerUpMovementController;
import Controllers.Sinusoidal;
import GameMaster.Timer;
import GameObjects.PiercingWeapon;
import GameObjects.Player;
import GameObjects.Vector2;
import GameObjects.Weapon;
import Map.Map;

public class PierceBulletPU extends AbstractPU {



    public PierceBulletPU(Vector2 v){
        controller = new PowerUpMovementController(this, new EnemyBehaviour(new Sinusoidal())); //TODO: crear movimientos de los power up
        health = 1;
        sprite = SpriteDepot.PEARCE;
        ubication = v;
        speed = 1;
        c = new PowerUpCollider(this);
        time = 5000;
        revert = new PiercingReverter();
        Map.getInstance().add(this);

    }

    @Override
    public void trigger() {
        Weapon w = new PiercingWeapon();
        Player.getInstance().setWeapon(w);

        Timer t = new Timer(time);
        Revert r = new PierceWeaponRevert(t, revert);
    }
}











