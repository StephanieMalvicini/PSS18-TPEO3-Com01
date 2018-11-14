package GameObjects;

import Assets.SpriteDepot;
import Collisions.PlayerBulletCollider;

import javax.swing.*;

public class BasicPlayerBullet extends PlayerBullet {
	public BasicPlayerBullet(float d, Vector2 ubication) {
		setUbication(ubication);
		daño = d;
		dir = new Vector2(0, -1);
		speed = 9.3f;
		sprite = SpriteDepot.LASER;
		health = 1;
		c = new PlayerBulletCollider(this);
	}

}