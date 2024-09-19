package actividad2;

import java.util.ArrayList;

public class HornoBizcocho extends Thread {
    private final ArrayList<Bizcocho> bizcochos;

    public HornoBizcocho(ArrayList<Bizcocho> bizcochos) {
        this.bizcochos = bizcochos;
    }

    @Override
    public void run() {
        int numero = 1;

        while (true) {
            System.out.println("Horno de Bizcocho: Produciendo... ");
            ToolThread.sleep(400, 600);
            Bizcocho bizcocho = new Bizcocho(numero);

            System.out.println("Horno de Bizcocho: Se produjo... " + bizcocho.getNOMBRE() + " numero " + bizcocho.getNUMERO());

            synchronized (bizcochos) {
                bizcochos.add(bizcocho);
                bizcochos.notify();
            }

            numero++;
        }
    }
}
