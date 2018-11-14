package PowerUps;

import GameObjects.Vector2;

public class PierceBulletPUFactory extends AbstractPowerUpFactory {

    public PierceBulletPUFactory(){
    }

    @Override
    public AbstractPU newPowerUp(Vector2 pos) {
        return new PierceBulletPU(pos);
    }
}
