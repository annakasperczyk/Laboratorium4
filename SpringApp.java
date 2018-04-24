package springapp;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Timer;
import javax.swing.JFrame;

public class SpringApp extends JFrame {

    private Dimension size;
    private SimEngine engine;
    private SimTask task;
    private Timer timer;
    private Image img;
    private Graphics gfx;

    public SpringApp(Dimension res) {
        size = res;
        setSize(size);

        engine = new SimEngine(50f, 200f, 5f, 3f, new Vector2D(0f, -1f), new Vector2D(0f, 0f), new Vector2D(0f, 2f), new Vector2D(0f, -10f));
        task = new SimTask(engine, this, 1f / 100f);
        timer = new Timer();

        timer.scheduleAtFixedRate(task, 0, (long) (1000f / 100f));
    }

    public static void main(String[] args) {
        SpringApp app = new SpringApp(new Dimension(400,400));
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    public void paint(Graphics g) {
        img = createImage(size.width, size.height);
        gfx = img.getGraphics();
        paintComponent(gfx);
        g.drawImage(img, 0, 0, null);
    }

    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, size.width, size.height);

        Vector2D fPos = engine.getObciazenie().mnozenieWektora(30f).sumaWektorow(new Vector2D((float) size.width / 2f, -(float) size.height / 8f));
        Vector2D mPos = engine.getMPos().mnozenieWektora(30f).sumaWektorow(new Vector2D((float) size.width / 2f, -(float) size.height / 3f));

        int mass_r = 20;

        g.drawLine((int) mPos.odcieta, -(int) mPos.rzedna, (int) fPos.odcieta, -(int) fPos.rzedna);
        g.drawOval((int) mPos.odcieta - mass_r, -(int) mPos.rzedna - mass_r, mass_r * 2, mass_r * 2);
    }

}
