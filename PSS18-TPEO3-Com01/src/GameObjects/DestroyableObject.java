package GameObjects;

import Collisions.Collider;

import javax.swing.*;

public abstract class DestroyableObject extends GameObject {
	protected float health;
	protected Collider c;
	protected Icon sprite;


	public Icon getSprite() {
		return sprite;
	}
	
	public float getHealth() {
		return health;
	}

	public Collider getCollider(){
		return c;
	}

	public boolean isAlive() {
		return health > 0;
	}

	public abstract void destroySelf(); // TODO: refactorear detruccion de entidades

	public void damage(float d){
		health -= d;

	}

	
}
