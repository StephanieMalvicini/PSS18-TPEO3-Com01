package Map;

import Assets.Configs;
import GameObjects.GameObject;
import GameObjects.MovingObject;
import GameObjects.Vector2;

public class OffsetPosition extends GameObject {
    Vector2 offset;
    MovingObject followed;

    public OffsetPosition(MovingObject f, Vector2 o){
        offset = o;
        followed = f;
        ubication = f.getUbication().sum(o);
        Map.getInstance().add(this);
    }
    @Override
    public void update(Map map) {

        ubication = followed.getUbication().sum(offset);
        float x = ubication.getX();
        float y = ubication.getY();


        if(x < -fieldMarginX )
            x = Configs.getConfigs().getCanvasWidth() + fieldMarginX;
        if (x > Configs.getConfigs().getCanvasWidth() + fieldMarginX)
            x = -fieldMarginX + (x - Configs.getConfigs().getCanvasWidth() + fieldMarginX);//acomoda lo que se desfazo por derecha y lo pone a esa distancia del borde izquierdo


        if(y < -fieldMarginY )
            y = Configs.getConfigs().getCanvasHeight() + fieldMarginY;
        if (y > Configs.getConfigs().getCanvasHeight() + fieldMarginY)
            y = -fieldMarginY;

        ubication = new Vector2(x,y);
    }

    @Override
    public void destroyMe(Map map) {
        map.remove(this);

    }
}
