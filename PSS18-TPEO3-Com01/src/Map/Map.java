package Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JLabel;

import Controllers.IController;
import GUI.IUpdatable;
import GUI.Window;
import GameObjects.*;

public final class Map extends SuperMap{

	private HashMap<GameObject, GraphicObject> gameobject_to_graphicobject;
	Collection<IUpdatable> list;

	private	Queue<IUpdatable> toDestroy;
	private Queue<IUpdatable> toAdd;
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
			throw new MapException("incicializa el mapa pete");
		return instance;
	}

	public void restart() {
		for(GraphicObject ob : gameobject_to_graphicobject.values()){
			ob.destroy();
		}
		gameobject_to_graphicobject.clear();
		gameobject_to_graphicobject = new HashMap<>();
		list = new LinkedList<>();
		list.clear();
		toDestroy.clear();
		toDestroy = new LinkedBlockingQueue<>(50);
		toAdd.clear();
		toAdd = new LinkedBlockingQueue<>(50);
	}
	
	private Map(Window w) {
		gameobject_to_graphicobject = new HashMap<>();
		list = new LinkedList<>();
		lvl = 0;
		wind = w;
		toDestroy = new LinkedBlockingQueue<>(50);
		toAdd = new LinkedBlockingQueue<>(50);

	}



	  public void run() {
		   wind.Show();
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

	public void add(IUpdatable u){
		toAdd.add(u);
	}



	public void update() {

		while(!toDestroy.isEmpty()){
			list.remove(toDestroy.remove());
		}
		while(!toAdd.isEmpty()){
			list.add(toAdd.remove());
		}

		for (IUpdatable o : list) {
			o.update(this);
		}

	}




	public void remove(IUpdatable upda)
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



}


