package actividad6;

public class Matriz {
    private final int FILAS;
    private final int COLUMNAS;
    private final int[][] matriz;

    public Matriz() {
        this(3, 6);
    }

    public Matriz(int filas, int columnas) {
        if (filas <= 0 || columnas <= 0) throw new RuntimeException("El tamaño no es valido");
        FILAS = filas;
        COLUMNAS = columnas;
        this.matriz = new int[filas][columnas];
        cargarMatriz();
    }

    public void agregar(int x, int y, int dato) {
        matriz[x][y] = dato;
    }

    public int dato(int x, int y) {
        return matriz[x][y];
    }

    public void cargarMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (int) (Math.random() * (100 - 1 + 1) + 1);
            }
        }
    }

    public int getFILAS() {
        return FILAS;
    }

    public int getCOLUMNAS() {
        return COLUMNAS;
    }

    @Override
    public String toString() {
        if (matriz.length == 0) throw new RuntimeException("Matriz vacía");
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        for (int[] fila : matriz) {
            for (int columna : fila) {
                builder.append(columna).append("\t");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
