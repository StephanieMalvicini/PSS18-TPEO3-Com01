package GameObjects;



public class BasicWeapon extends Weapon{

    public BasicWeapon(float dmg){
        damage = dmg;
        gunPosition = -7;
        gunPhaseShift = 20;
    }

    public void shoot(){
        Vector2 ubBullet = Player.getInstance().getUbication().sum(Vector2.RIGHT(gunPosition+gunPhaseShift));
        new BasicPlayerBullet(damage,ubBullet);
        gunPhaseShift *= -1;
    }
}
