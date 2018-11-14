package Map;

import javax.swing.*;

import GUI.IUpdateable;
import GUI.Window;
import GameObjects.DestroyableObject;

public class GraphicObject implements IUpdateable {
	protected DestroyableObject object;
	protected JLabel model;
	
	public GraphicObject(DestroyableObject o, JLabel l) {
		object = o;
		model = l;
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
