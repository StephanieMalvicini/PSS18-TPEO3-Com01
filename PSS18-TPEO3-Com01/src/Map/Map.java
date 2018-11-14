package Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JLabel;

import Controllers.IController;
import GUI.IUpdateable;
import GUI.ScoreManager;
import GUI.Window;
import GameObjects.*;

public final class Map{

	private HashMap<GameObject, GraphicObject> gameobject_to_graphicobject;
	Collection<IUpdateable> list;

	private	Queue<IUpdateable> toDestroy;
	private Queue<IUpdateable> toAdd;
	private Window wind;
	private Formation form;
	private int lvl;




	private static Map instance;

	public static Map newInstance(Window w){
		if (instance == null){
			instance = new Map(w);
		}
		return instance;
	}

	public static Map getInstance() {
		if (instance == null)
			throw new MapException("incicializa el mapa");
		return instance;
	}

	private Map(Window w) {
		gameobject_to_graphicobject = new HashMap<>();
		list = new LinkedList<>();
		lvl = 0;
		wind = w;
		toDestroy = new LinkedBlockingQueue<>(500);
		toAdd = new LinkedBlockingQueue<>(500);
		add(ScoreManager.getInstance());

	}





	public void add(GameObject o){
		toAdd.add(o);
	}

	public void add(DestroyableObject o)
	{
		JLabel l = wind.add(o.getUbication(), o.getSprite());
		GraphicObject ret =  new GraphicObject(o, l);
		toAdd.add(ret);
		gameobject_to_graphicobject.put(o,ret);
	}

	public void add(IUpdateable u){
		toAdd.add(u);
	}



	public void update() {

		while(!toDestroy.isEmpty()){
			list.remove(toDestroy.remove());
		}
		while(!toAdd.isEmpty()){
			list.add(toAdd.remove());
		}

		for (IUpdateable o : list) {
			o.update(this);
		}

	}




	public void remove(IUpdateable upda)
	{
		toDestroy.add(upda);
	}



	public void destroy(GameObject gam)
	{
		GraphicObject go = gameobject_to_graphicobject.getOrDefault(gam,null);
		remove(go);
	}

	public void destroy(IController controller) {
		remove(controller);
	}

	public Formation getFormation(){
		return form;
	}

	public void newLevel(){
		form = new Formation(++lvl);
		form.createEnemies();
	}


	public int getLevel() {
		return lvl;
	}
}


