package Controllers;

import Assets.Paths;
import GUI.MyListener;
import GameObjects.Player;
import GameObjects.Vector2;
import Map.Map;

import javax.swing.*;

public class PlayerMovementController extends MovementController {





	public PlayerMovementController(Player p) {
		r = new ImageIcon(Paths.NAVEDER);
		l = new ImageIcon(Paths.NAVEIZQ);
		d = new ImageIcon(Paths.NAVED);
		u = new ImageIcon(Paths.NAVEU);
		lu = new ImageIcon(Paths.NAVEIU);
		ru = new ImageIcon(Paths.NAVEDU);
		rd = new ImageIcon(Paths.NAVED);
		ld = new ImageIcon(Paths.NAVED);
		c = new ImageIcon(Paths.NAVE);
		controlled = p;

		m = new ImageIcon[3][3];
		m[0][0]=lu;
		m[1][0]=u;
		m[2][0]=ru;
		m[0][1]=l;
		m[1][1]=c;
		m[2][1]=r;
		m[0][2]=rd;
		m[1][2]=d;
		m[2][2]=ld;

		Map.getInstance().add(this);
	}

	public void update(Map map)
	{
		if (true) {
			Vector2 vec = armarVector();
			move(vec);
		}
		else
			destroyMe(map);
	}








	public void destroyMe(Map map) {
		map.destroy(this);
	}

	protected Vector2 armarVector()
	{
		MyListener input = MyListener.Instance();

		Vector2 vec = Vector2.ORIGIN();

		if(input.down()) {
			vec = vec.sum(Vector2.DOWN());

		}

		if(input.up()) {
			vec = vec.sum(Vector2.UP());

		}

		if(input.left()) {
			vec = vec.sum(Vector2.LEFT());
		}

		if(input.right()) {
			vec = vec.sum(Vector2.RIGHT());
		}

		return vec;
	}



}
