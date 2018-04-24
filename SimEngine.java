package springapp;

public class SimEngine {

    private float masa, sprezystosc, tlumienie, dlugosc;
    private Vector2D polMasy, predkoscMasy, pktZaw, grawitacja;

    public Vector2D getMPos() {
        return polMasy;
    }

    public Vector2D getObciazenie() {
        return pktZaw;
    }

    public SimEngine(float m, float k, float c, float l0, Vector2D pM, Vector2D prM, Vector2D f, Vector2D g) {
        masa = m;
        sprezystosc = k;
        tlumienie = c;
        dlugosc = l0;
        polMasy = pM;
        predkoscMasy = prM;
        pktZaw = f;
        grawitacja = g;
    }

    public void Update(float time) {
        float x = pktZaw.sumaWektorow(polMasy.mnozenieWektora(-1f)).dlugoscWektora() - dlugosc;
        Vector2D doWahadla = pktZaw.sumaWektorow(polMasy.mnozenieWektora(-1f)).znormalizowanie();

        predkoscMasy = predkoscMasy.sumaWektorow(doWahadla.mnozenieWektora(sprezystosc * x / masa * time));

        float mnozenieSkalarne = doWahadla.rzedna * predkoscMasy.rzedna + doWahadla.odcieta * predkoscMasy.odcieta;
        predkoscMasy = predkoscMasy.sumaWektorow(doWahadla.mnozenieWektora(-tlumienie / masa * time * mnozenieSkalarne));

        predkoscMasy = predkoscMasy.sumaWektorow(grawitacja.mnozenieWektora(time));
        polMasy = polMasy.sumaWektorow(predkoscMasy.mnozenieWektora(time));
    }

    public void Reset() {
    	predkoscMasy = new Vector2D(0f, 0f);
    }
}
