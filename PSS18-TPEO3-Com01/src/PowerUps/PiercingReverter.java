package PowerUps;

import GameObjects.Player;
import GameObjects.PlayerWeapon;
import GameObjects.Weapon;

public class PiercingReverter implements Runnable {
    @Override
    public void run() {
        System.out.println("desactivo");
        Weapon w = new PlayerWeapon(Player.getInstance().getDamage());
        Player.getInstance().setWeapon(w);


    }
}
