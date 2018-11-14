package PowerUps;


import GameMaster.DoWhen;

import java.util.concurrent.Callable;

public abstract class Revert extends DoWhen {


    public Revert(Callable<Boolean> condition, Runnable action) {
        super(condition, action);
    }
}
