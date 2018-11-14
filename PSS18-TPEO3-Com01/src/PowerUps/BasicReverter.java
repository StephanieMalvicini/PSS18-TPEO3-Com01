package PowerUps;

import GameObjects.Player;
import GameObjects.BasicWeapon;
import GameObjects.Weapon;

public class BasicReverter implements Runnable {
    @Override
    public void run() {
        Weapon w = new BasicWeapon(Player.getInstance().getDamage());
        Player.getInstance().setWeapon(w);
    }
}
