package GameMaster;

import GUI.IUpdateable;
import Map.Map;

import java.util.concurrent.Callable;

public class DoInFrames implements IUpdateable
{
    private Callable<Boolean> Condition;
    private Runnable Action;
    private boolean excecuted;
    private int i;
    public DoInFrames(int cantFrames, Runnable action)
    {
        i =0;
        Condition = ()->cantFrames>i;
        Action = action;
        excecuted = false;
        Map.getInstance().add(this);
    }


    @Override
    public void update(Map map)
    {
        boolean cond;
        try {
            cond = Condition.call();
        } catch (Exception e) {cond = false;}
        if(cond && !excecuted)
        {
            excecuted = true;
            Action.run();
        }
        if(excecuted){
            map.remove(this);
        }
        i++;
    }

    @Override
    public void destroyMe(Map map) {

    }
}