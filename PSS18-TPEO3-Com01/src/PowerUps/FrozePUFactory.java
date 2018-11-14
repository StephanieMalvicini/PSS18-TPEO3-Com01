package PowerUps;

import GameObjects.Vector2;

public class FrozePUFactory extends AbstractPowerUpFactory {

    public FrozePUFactory(){
    }

    @Override
    public AbstractPU newPowerUp(Vector2 pos) {
        return new FrozePU(pos);
    }
}
