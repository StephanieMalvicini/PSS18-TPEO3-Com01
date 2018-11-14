package GameObjects;

import Assets.Configs;
import Assets.SpriteDepot;
import Collisions.Collider;
import Collisions.PlayerCollider;
import GUI.Menu;
import Map.*;

import javax.swing.*;

public class Player extends Ship{
	protected final float playerSpeed = 8.6f;
	protected int damage;
	protected int attackSpeed;
	protected boolean loaded;
	protected long time;
	protected Weapon weapon;


	protected static Vector2 initialPosition = new Vector2(218,680);
	protected int playerAttackSpeed = 500;

	private static Player instance = null;
	private Shield shield;

	public static Player getInstance() {
		if (instance == null)
			instance = new Player();
		return instance;
	}

	private Player() {
		health = 200;
		speed = playerSpeed;
		time=0;
		ubication = initialPosition;
		dir = Vector2.ORIGIN();
		damage = 30;
		sprite = SpriteDepot.NAVE;
		attackSpeed = playerAttackSpeed;
		loaded = true;
		isFiring = false;
		c = new PlayerCollider(this);
		shield = new Shield(0);
		weapon = new PlayerWeapon(damage);
	}




	
	public void update(Map map) {

		if (health > 0) {
			checkFire(map);
			updatePosition(map);
			super.update(map);
		} else {
			destroySelf();
			destroyMe(map);
			sprite = new ImageIcon();
			c.destroySelf();
			Menu.getInstance().perder();
		}

	}

	private void checkFire(Map map) {

		if (time < System.currentTimeMillis())
			loaded = true;
		if (loaded && isFiring) {
			loaded = false;
			time = System.currentTimeMillis() + attackSpeed;

			weapon.shoot();

		}


	}

	@Override
	protected void updatePosition(Map map) {
		float x = ubication.getX();
		float y = ubication.getY();


		x += dir.getX() * speed;
		if(x < -50)
			x = -50;                      //TODO: Arreglar el choque con bordes con las longitudes de los sprites
		if (x > Configs.getConfigs().getCanvasWidth() -250)
			x = Configs.getConfigs().getCanvasWidth() -250;

		y += dir.getY() * speed;
		if(y < -50)
			y = -50;
		if (y > Configs.getConfigs().getCanvasHeight() - 180)
			y = Configs.getConfigs().getCanvasHeight() - 180;

		ubication = new Vector2(x,y);
	}

	public Shield getShield() {
		return shield;
	}

	public void damage(float d){
		float x = shield.calculateDamage(d);
		health -= x;

	}

	public void setCollider(Collider co){
		c.destroySelf();
		c = co;
	}


	public float getDamage() {
		return damage;
	}

	public void setWeapon(Weapon w) { //TODO modificar para que copie cualqueir modificador del arma anterior a la nueva arma
		weapon = w;

	}
}
	
	
	
	
	
	


