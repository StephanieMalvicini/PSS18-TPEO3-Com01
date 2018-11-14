package PowerUps;

import GameObjects.Vector2;

public class MissilPUFactory extends AbstractPowerUpFactory {
    @Override
    public AbstractPU newPowerUp(Vector2 vec) {
        return new MissilPU(vec);
    }
}
