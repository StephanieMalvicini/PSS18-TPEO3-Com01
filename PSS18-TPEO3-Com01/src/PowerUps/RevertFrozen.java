package PowerUps;

import java.util.concurrent.Callable;

public class RevertFrozen extends Revert {
    public RevertFrozen(Callable<Boolean> condition, Runnable action) {
        super(condition, action);
    }
}
