package PowerUps;

import GameObjects.Vector2;

public class KamikazeShieldPUFactory extends AbstractPowerUpFactory {

    public KamikazeShieldPUFactory(){
    }

    @Override
    public AbstractPU newPowerUp(Vector2 pos) {
        return new KamikazeShieldPU(pos);
    }
}