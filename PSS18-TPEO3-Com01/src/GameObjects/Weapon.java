package GameObjects;

public abstract class Weapon {
    protected int gunPosition;
    protected float gunPhaseShift;
    protected float damage;

    protected abstract void shoot();
}
