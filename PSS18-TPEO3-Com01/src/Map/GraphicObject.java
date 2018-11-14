package Map;

import javax.swing.*;

import GUI.IUpdatable;
import GUI.Window;
import GameMaster.DoInFrames;
import GameMaster.DoWhen;
import GameObjects.DestroyableObject;
import GameObjects.GameObject;

public class GraphicObject implements IUpdatable {
	protected DestroyableObject object;
	protected JLabel model;
	
	public GraphicObject(DestroyableObject o, JLabel l) {
		object = o;
		model = l;
	}
	
	public JLabel getLabel(){
		return model;
	}

	public DestroyableObject getObject(){
		return object;
	}
	


	
	public void update(Map map) {
		object.update(map);

		int x = object.getX();
		int y = object.getY();

		model.setIcon(object.getSprite());
		model.setBounds(x, y, 182, 200);

	}

	@Override
	public void destroyMe(Map map) {
		destroy();
	}



	public void destroy() {


		model.setVisible(false);
		Window.GetWindow().removeComponent(model);





	}
}
