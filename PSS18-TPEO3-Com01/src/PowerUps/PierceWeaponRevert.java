package PowerUps;

import java.util.concurrent.Callable;

public class PierceWeaponRevert extends Revert {
    public PierceWeaponRevert(Callable<Boolean> condition, Runnable action) {
        super(condition, action);
    }


}
