package springapp;

import java.util.TimerTask;

public class SimTask extends TimerTask{
    private SimEngine engine;
    private SpringApp app;
    private float timestep;
    
    public SimTask(SimEngine se, SpringApp sa, float ts) {
        engine = se;
        app = sa;
        timestep = ts;
    }

    public void run() {
        engine.Update(timestep);
        app.repaint();
    }
    
}
