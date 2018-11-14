package PowerUps;

import GameObjects.Vector2;

public class ShieldPUFactory extends AbstractPowerUpFactory {

    public ShieldPUFactory(){
    }

    @Override
    public AbstractPU newPowerUp(Vector2 pos) {
        return new ShieldPU(pos);
    }
}
