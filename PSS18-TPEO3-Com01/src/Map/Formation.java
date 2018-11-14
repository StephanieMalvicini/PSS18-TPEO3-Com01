package Map;

import Assets.Configs;
import Assets.SpriteDepot;
import Collisions.DummyCollider;
import Collisions.Visitor;
import Controllers.*;
import GameObjects.*;
import PowerUps.AbstractPowerUpFactory;

import java.util.Collection;
import java.util.LinkedList;

public class Formation extends MovingObject {

    protected Collection<EnemyMovementController> enemies;
    protected AbstractPowerUpFactory puf;
    protected int lvl;
    protected Collection<OffsetPosition>positions;
    Vector2 offset;
    int distX, distY;

   public Formation(int d){
       health = 1;
       speed = 0.19f;
       ubication = new Vector2(200, 200);
       Behaviour b = new EnemyBehaviour(new Sinusoidal());
       dir = Vector2.ORIGIN();
       new EnemyMovementController(this, b);
       enemies = new LinkedList<>();
       lvl = d;
       sprite = SpriteDepot.FROZE;
       c = new DummyCollider(this);
       Map.getInstance().add(this);
       offset = new Vector2(-20, 0);
       distX = 180;
       distY = 30;

   }

    public void createEnemies() {
        Enemy e;
        e = new EnemyFighterOnlyShoot(lvl);
        enemies.add(new EnemyMovementController(e, new FollowBehaviour(e, new OffsetPosition(this,offset))));
       e = new EnemyFighterHybrid(lvl);
       offset = offset.sum(new Vector2(distX,0));
        enemies.add(new EnemyMovementController(e, new FollowBehaviour(e, new OffsetPosition(this, offset))));
        e = new KamicazeEnemy(lvl);
        offset = offset.sum(new Vector2(distX,0));
        enemies.add(new EnemyMovementController(e, new FollowBehaviour(e, new OffsetPosition(this, offset))));
    }


    public void affect(Visitor v){
       for(EnemyMovementController c : enemies){
           c.getShip().getCollider().accept(v);
       }
   }

   private void LevelEnd(){
       Map.getInstance().newLevel();
   }

   public void update(Map map){
       updatePosition(map);
       super.update(map);
   }

    @Override
    protected void updatePosition(Map m) {
        float x = ubication.getX();
        float y = ubication.getY();

        dir = dir.max(maxSpeed);

        x += dir.getX() * speed;
        if(x < -fieldMarginX )
            x = Configs.getConfigs().getCanvasWidth() + fieldMarginX;
        if (x > Configs.getConfigs().getCanvasWidth() + fieldMarginX)
            x = -fieldMarginX;

        y += dir.getY() * speed;
        if(y < -fieldMarginY )
            y = Configs.getConfigs().getCanvasHeight() + fieldMarginY;
        if (y > Configs.getConfigs().getCanvasHeight() + fieldMarginY)
            y = -fieldMarginY;

        ubication = new Vector2(x,y);

    }

}
