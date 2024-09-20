package actividad3;

public class Pasillo {
    private int contador;

    public Pasillo() {
        contador = 0;
    }

    public void add() {
        contador++;
    }

    public void remove() {
        contador--;
    }

    public boolean esEmpty() {
        return contador == 0;
    }
}
