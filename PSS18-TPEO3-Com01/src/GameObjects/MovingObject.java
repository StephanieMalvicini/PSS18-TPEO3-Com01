package GameObjects;


import Map.Map;

import javax.swing.*;

public abstract class MovingObject extends DestroyableObject {
	protected float speed;
	protected float maxSpeed = 65;
	protected Vector2 dir;
	
	public void update(Map map) {
		c.update();
	}

	protected abstract void updatePosition(Map m);

	public void destroyMe(Map map) {
		map.destroy(this);

	}

	public void setDirec(Vector2 vect) {
		dir = (vect);

	}

	public void setSprite(Icon s){
		sprite = s;
	}




	@Override
	public void destroySelf() {
		destroyMe(Map.getInstance());

	}


}
