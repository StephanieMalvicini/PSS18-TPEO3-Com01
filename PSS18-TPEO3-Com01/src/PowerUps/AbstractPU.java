package PowerUps;

import Assets.Configs;
import Controllers.IMovementController;
import GameObjects.MovingObject;
import GameObjects.Vector2;
import Map.Map;

import javax.swing.*;

public abstract class AbstractPU extends MovingObject {

        protected IMovementController controller;
        protected Runnable revert;
        public abstract void trigger();
        protected long time;
        protected int l;


        protected void updatePosition(Map map) {
                float x = ubication.getX();
                float y = ubication.getY();



                y += dir.getY() * speed;
                if(y < -50 || y > Configs.getConfigs().getCanvasHeight() - 220)
                        destroySelf();

                x += dir.getX() * speed;
                if(x < -150)
                        x = Configs.getConfigs().getCanvasWidth() + 150;
                if (x > Configs.getConfigs().getCanvasWidth() + 150)
                        x = -150;




                ubication = new Vector2(x,y);
        }

        public void destroySelf(){
                destroyMe(Map.getInstance());
                c.destroySelf();
                sprite = new ImageIcon();
        }





}
