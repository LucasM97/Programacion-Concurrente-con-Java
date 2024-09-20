package actividad3;

import java.util.Random;

public class ToolThread extends Thread {
    public ToolThread() {
        super();
    }

    public static void sleepThread(int inicio, int fin) {
        Random random = new Random();
        int num = random.nextInt((fin - inicio) + 1) + inicio;

        try {
            sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleepThread(int num) {
        try {
            sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
