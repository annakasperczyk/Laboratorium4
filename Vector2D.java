
package springapp;

public class Vector2D {

    public float rzedna, odcieta;

    public Vector2D() {
        rzedna = 0f;
        odcieta = 0f;
    }

    public Vector2D(float x, float y) {
        odcieta = x;
        rzedna = y;
    }

    public Vector2D sumaWektorow(Vector2D wektor) {
        return new Vector2D(odcieta + wektor.odcieta, rzedna + wektor.rzedna);
    }

    public Vector2D roznicaWektorow(Vector2D wektor) {
        return new Vector2D(odcieta - wektor.odcieta, rzedna - wektor.rzedna);
    }

    public Vector2D mnozenieWektora(float a) {
        return new Vector2D(odcieta*a, rzedna*a);
    }

    public float dlugoscWektora() {
        return (float) Math.sqrt(odcieta * odcieta + rzedna * rzedna);
    }

    public Vector2D znormalizowanie() {
        return mnozenieWektora(1 / dlugoscWektora());
    }

    public String toString() {
        return "(" + odcieta + ", " + rzedna + ")";
    }

}
