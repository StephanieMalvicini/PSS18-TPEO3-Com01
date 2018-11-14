package GameObjects;

import Assets.Configs;
import GUI.IUpdatable;

import javax.swing.*;

public abstract class GameObject implements IUpdatable {
	protected Vector2 ubication;
	protected int fieldMarginY = (Configs.getConfigs().getFieldHeigth() - Configs.getConfigs().getCanvasHeight())/2 ;
	protected int fieldMarginX = (Configs.getConfigs().getFieldWidth() - Configs.getConfigs().getCanvasWidth())/2;

	public Vector2 getUbication() {
		return ubication;
	}
	public Vector2Int getRawUbication() {
		return Vector2Int.Implicit(ubication);
	}

	public void setUbication(Vector2 ubication) {
		this.ubication = ubication;
	}

	public int getX() {
		return Math.round(ubication.getX());
	}
	public int getY() {
		return Math.round(ubication.getY());
	}

}
