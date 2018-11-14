package Collisions;

import Collisions.Visitor;

public interface Visitable {

    public void accept(Visitor v);

}
