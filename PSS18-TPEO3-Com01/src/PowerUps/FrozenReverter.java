package PowerUps;

import Collisions.Visitor;
import Map.Map;

public class FrozenReverter implements Runnable {

    Visitor v;

    public FrozenReverter(){
        Visitor v = new UnfrozeVisitor();
    }

    @Override
    public void run() {
        Map.getInstance().getFormation().affect(v);
    }
}
