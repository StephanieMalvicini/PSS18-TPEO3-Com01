package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.atomic.AtomicBoolean;

public class MyListener implements KeyListener {


    private static MyListener instance;
    public static MyListener getInstance()
    {
        if(instance==null)
            instance = new MyListener();
        return  instance;
    }


    private final AtomicBoolean up = new AtomicBoolean(false);
    private final AtomicBoolean down = new AtomicBoolean(false);
    private final AtomicBoolean left = new AtomicBoolean(false);
    private final AtomicBoolean right = new AtomicBoolean(false);
    private final AtomicBoolean fire = new AtomicBoolean(false);
    
    public synchronized boolean up()
    {
    	return up.get();
    }
    public synchronized boolean down()
    {
    	return down.get();
    }
    public synchronized boolean left()
    {
    	return left.get();
    }
    public synchronized boolean right()
    {
    	return right.get();
    }
    public synchronized boolean fire()
    {
    	return fire.get();
    }




    private MyListener()
    {
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_CONTROL){
            synchronized(fire)
            {
            	fire.lazySet(true);
            }            
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            synchronized(right)
            {
            	right.lazySet(true);
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
			synchronized(left)
			{
				left.lazySet(true);
			}
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            synchronized(up)
            { 
            up.lazySet(true);
        	}
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            synchronized(down)
            { 
			down.lazySet(true);
			}
        }

    }
    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_CONTROL){
            synchronized(fire)
            {
				fire.lazySet(false);            	
            }            
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            synchronized(right)
            {
				right.lazySet(false);            	
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
			synchronized(left)
			{
				left.lazySet(false);				
			}
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            synchronized(up)
            { 
				up.lazySet(false);            
        	}
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            synchronized(down)
            { 
				down.lazySet(false);			
			}
        }
    }


    @Override public void keyTyped(KeyEvent e) {}
}

