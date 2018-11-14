package PowerUps;

import java.util.LinkedList;

public class PowerUpPool {

    private static PowerUpPool instance;
    private LinkedList<AbstractPowerUpFactory> pool;

    private PowerUpPool(){
        pool = new LinkedList<AbstractPowerUpFactory>();
        pool.add(new FrozePUFactory());
        pool.add(new KamikazeShieldPUFactory());
        pool.add(new PotionPUFactory());
        pool.add(new PierceBulletPUFactory());
        pool.add(new ShieldPUFactory());
        pool.add(new MissilPUFactory());
    }

    public static PowerUpPool getInstance(){
        if(instance == null)
            instance = new PowerUpPool();
        return instance;
    }

    public LinkedList<AbstractPowerUpFactory> getPool(){
        return pool;
    }
}