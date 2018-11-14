package Collisions;

import GameObjects.Player;

public class PlayerCollider extends Collider{

    public PlayerCollider(Player o) {
        super(o);
        v = new PlayerVisitor();
    }



    @Override
    public void accept(Visitor v) {
        v.visitPlayer(this);

    }


}
