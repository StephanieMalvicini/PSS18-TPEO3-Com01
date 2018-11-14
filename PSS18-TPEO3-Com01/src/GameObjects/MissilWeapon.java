package GameObjects;


public class MissilWeapon extends Weapon {

    public MissilWeapon(){
        damage = Player.getInstance().getDamage();
        damage *= 5;
        gunPosition = -7;
        gunPhaseShift = 40;
    }

    public void shoot(){
        Vector2 ubBullet = Player.getInstance().getUbication().sum(Vector2.RIGHT(gunPosition+gunPhaseShift));
        new MissilBullet(damage,ubBullet);
        gunPhaseShift *= -1;
    }
}
