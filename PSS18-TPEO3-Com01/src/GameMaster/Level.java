package GameMaster;


import Assets.Configs;
import Controllers.*;
import GUI.MyListener;
import GUI.ScoreManager;
import GUI.Window;
import GameObjects.*;
import Map.Map;

import java.util.Random;

public class Level extends Thread{

	protected static Map map;
	protected long nanostowait;
	protected boolean seguir;

	public Level() {

		MyListener l = MyListener.getInstance();
		Window.GetWindow().addListener(l);
		map = Map.newInstance(Window.GetWindow());
		map.add(Player.getInstance());
		new PlayerFireController();
		PlayerMovementController c = new PlayerMovementController(Player.getInstance());
		Random rand = new Random();
		int yBarricade = (int) Configs.getConfigs().getCanvasHeight()/2;
		int xBarricade = rand.nextInt(Configs.getConfigs().getCanvasWidth()/2 - 400) + 200;
		new EnemyBarricade(xBarricade,yBarricade);
		yBarricade = (int) Configs.getConfigs().getCanvasHeight()/2;
		xBarricade = rand.nextInt(Configs.getConfigs().getCanvasWidth()/2-400) + Configs.getConfigs().getCanvasWidth()/2;
		new CommonBarricade(xBarricade,yBarricade);
		map.newLevel();



		seguir = true;

	}


	public void run(){

		Window.GetWindow().Show();
		long fpns = 80_000_000_000L;
		long stm;
		long latestmp;

		while(seguir) {
			stm = System.nanoTime();
			map.update();
			Window.GetWindow().update();
			latestmp = System.nanoTime();
			try
			{
				nanostowait = fpns-(latestmp-stm);

				if(nanostowait>0)
				{
					Thread.sleep(nanostowait/5_00_000_0000L);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}