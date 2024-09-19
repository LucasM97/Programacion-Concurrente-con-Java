package actividad2;

public class Producto {
    private final String NOMBRE;
    private final int NUMERO;

    public Producto(String nombre, int numero) {
        NOMBRE = nombre;
        NUMERO = numero;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public int getNUMERO() {
        return NUMERO;
    }
}
