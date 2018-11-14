package GUI;

import java.awt.*;
import java.awt.event.KeyListener;

import javax.swing.*;

import Assets.Configs;
import Assets.Paths;
import GameObjects.Vector2;
import GameObjects.Vector2Int;

public class Window {

    private static Window instance;

    private Container gameContainer;
    private Container UIcontainer;


    
    public static Window GetWindow()  {
        if(instance ==null){
           instance = new Window();
        }
        return instance;
    }
    private Window() {

		Icon ic = new ImageIcon(Paths.BACKGROUND);
		gameContainer = new JLabel(ic);
		Icon ic2 = new ImageIcon(Paths.OTROFONDO);
		UIcontainer = new JLabel(ic2);
		UIcontainer.setLayout(null);

		UIcontainer.add(ScoreManager.getInstance().getScore());
		UIcontainer.add(ScoreManager.getInstance().getVidaJugador());
		ScoreManager.getInstance().getScore().setBounds(20,200,100,100);

		ScoreManager.getInstance().getVidaJugador().setBounds(20,400,100,100);
		gameContainer.setBounds(Configs.getConfigs().getPanelWidth(),0,Configs.getConfigs().getCanvasWidth(),Configs.getConfigs().getCanvasHeight());
		UIcontainer.setBounds(0,0,Configs.getConfigs().getPanelWidth(),Configs.getConfigs().getCanvasHeight());

		gameContainer.setLayout(null);

		Menu.getInstance().addPanels(gameContainer,UIcontainer);



    }
    public void update(){
       Menu.getInstance().update();
    }

    public void Show() {
        Menu.getInstance().showFrame();
    }
    


    public  JLabel add(Vector2 ubication, Icon s) {
	    	Vector2Int	v = Vector2Int.Implicit(ubication);
		JLabel object = new JLabel(s);

		object.setBounds(v.getX(),v.getY(), s.getIconWidth(),s.getIconHeight());
		gameContainer.add(object);
		return object;
    }


    public void addListener(KeyListener k) { Menu.getInstance().getFrame().addKeyListener(k); }


	public void removeComponent(JComponent model)
	{
		Menu.getInstance().getFrame().remove(model);
	}
}