package GameObjects;

import Map.Map;

public class PlayerWeapon extends Weapon{

    public PlayerWeapon(float dmg){
        damage = dmg;
        gunPosition = -7;
        gunPhaseShift = 20;
    }

    public void shoot(){
        Vector2 ubBullet = Player.getInstance().getUbication().sum(Vector2.RIGHT(gunPosition+gunPhaseShift));
        Bullet b = new BasicPlayerBullet(damage,ubBullet);
        Map.getInstance().add(b);
        gunPhaseShift *= -1;
    }
}
