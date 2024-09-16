package actividad6;

public class Hilo extends Thread {
    private Matriz matrizA;
    private Matriz matrizB;
    private int numeroFila;

    public Hilo(Matriz matrizA, Matriz matrizB, int numeroFila) {
        this.matrizA = matrizA;
        this.matrizB = matrizB;
        this.numeroFila = numeroFila;
    }

    public synchronized void run() {
        int[] fila = new int[matrizA.getCOLUMNAS()];

        for (int j = 0; j < matrizA.getCOLUMNAS(); j++) {
            fila[j] = matrizA.dato(numeroFila, j);
            matrizA.agregar(numeroFila, j, matrizB.dato(j, numeroFila));
            matrizB.agregar(j, numeroFila, fila[j]);
        }
    }
}
