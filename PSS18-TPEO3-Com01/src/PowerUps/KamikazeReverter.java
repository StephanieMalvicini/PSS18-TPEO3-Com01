package PowerUps;

import Collisions.Collider;
import Collisions.PlayerCollider;
import GameObjects.Player;

public class KamikazeReverter implements Runnable {
    public boolean activo;


    public KamikazeReverter(){
        activo = true;

    }
    @Override
    public void run() {
        if(activo) {
            Collider c = new PlayerCollider(Player.getInstance());
            Player.getInstance().setCollider(c);
            activo = false;
        }

    }
}
