package PowerUps;

@Deprecated
public class PowerUpFactory extends AbstractPowerUpFactory{

    int lvl;
    public PowerUpFactory(int l){
        lvl = l;
    }

    @Override
    AbstractPU newFroze() {
        return null;
    }

    @Override
    AbstractPU newShield() {
        return null;
    }

    @Override
    AbstractPU newKamikazeShield() {
        return null;
    }

    @Override
    AbstractPU newPiercing() {
        return null;
    }
}
