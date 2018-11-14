package PowerUps;

import java.util.concurrent.Callable;

public class BasicWeaponRevert extends Revert {
    public BasicWeaponRevert(Callable<Boolean> condition, Runnable action) {
        super(condition, action);
    }


}
