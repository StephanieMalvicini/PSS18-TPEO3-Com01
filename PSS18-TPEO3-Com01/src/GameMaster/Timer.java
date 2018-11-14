package GameMaster;

import java.util.concurrent.Callable;

public class Timer implements Callable {
    long current, ending;

    public Timer(long t){
        current = System.currentTimeMillis();
        ending = current + t;
    }

    @Override
    public Object call() throws Exception {
        current = System.currentTimeMillis();
        return current>ending;
    }
}
