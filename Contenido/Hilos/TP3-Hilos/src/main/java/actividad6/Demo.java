package actividad6;

public class Demo {
    public static void main(String[] args) {
        Matriz matrizA = new Matriz();
        Matriz matrizB = new Matriz(matrizA.getCOLUMNAS(), matrizA.getFILAS());

        System.out.println("### Matriz A ##########################################\n" + matrizA);
        System.out.println("### Matriz B ##########################################\n" + matrizB);

        Thread[] hilos = new Thread[matrizA.getFILAS()];

        for (int i = 0;i < hilos.length; i++) {
            hilos[i] = new Thread(new Hilo(matrizA,matrizB,i));
            hilos[i].start();
        }

        for (Thread h : hilos) {
            try {
                h.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("### Matriz A ##########################################\n" + matrizA);
        System.out.println("### Matriz B ##########################################\n" + matrizB);
    }
}
