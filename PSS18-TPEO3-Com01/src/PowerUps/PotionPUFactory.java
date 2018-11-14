package PowerUps;

import GameObjects.Vector2;

public class PotionPUFactory extends AbstractPowerUpFactory{

    @Override
    public AbstractPU newPowerUp(Vector2 vec) {
        return new PotionPU(vec);
    }
}
