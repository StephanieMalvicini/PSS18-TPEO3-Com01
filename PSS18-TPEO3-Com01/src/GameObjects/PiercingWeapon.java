package GameObjects;



public class PiercingWeapon extends Weapon{

    public PiercingWeapon(){
        damage = Player.getInstance().getDamage();
        damage *= 0.75;
        gunPosition = -7;
        gunPhaseShift = 40;
    }

    public void shoot(){
        Vector2 ubBullet = Player.getInstance().getUbication().sum(Vector2.RIGHT(gunPosition+gunPhaseShift));
        new PiercingBullet(damage,ubBullet);
        gunPhaseShift *= -1;
    }
}
