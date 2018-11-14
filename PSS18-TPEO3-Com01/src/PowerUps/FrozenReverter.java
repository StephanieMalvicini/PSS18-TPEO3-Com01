package PowerUps;

import Collisions.PowerUpVisitor;
import Collisions.Visitor;
import Map.Map;

public class FrozenReverter implements Runnable {

    protected PowerUpVisitor v;

    public FrozenReverter(){
        v = new UnfrozeVisitor();
    }

    @Override
    public void run() {
        Map.getInstance().getFormation().affectPowerUp(v);
    }
}
