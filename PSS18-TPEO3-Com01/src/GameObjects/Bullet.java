package GameObjects;

import Assets.Configs;
import Map.Map;

import javax.swing.*;

public abstract class Bullet extends Ship {
	protected float daño;
	
	public float getDaño(){return daño;}



	public void destroyMe(Map map) {
		map.destroy(this);
		sprite = new ImageIcon();
	}



	public void destroySelf()
	{
		c.destroySelf();
		Map.getInstance().destroy(this);
		sprite = new ImageIcon();
	}


	@Override
	protected void updatePosition(Map map) {
		float x = ubication.getX();
		float y = ubication.getY();

		y += dir.getY() * speed;
		x += dir.getX() * speed;
		if(x < -12 || x > 1400 || y < -310 || y > Configs.getConfigs().getCanvasHeight() + 520) {
			destroySelf();
		}

		ubication = new Vector2(x,y);
	}
	
	
	
}
