package PowerUps;

import Map.Map;

import java.util.concurrent.Callable;

public class RevertKS extends Revert {

    public RevertKS(Callable<Boolean> condition, Runnable action) {
        super(condition, action);
        Map.getInstance().add(this);
    }
}
