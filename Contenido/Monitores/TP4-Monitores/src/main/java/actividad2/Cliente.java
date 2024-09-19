package actividad2;

import java.util.ArrayList;

public class Cliente extends Thread {
    private final int NUMERO_CLIENTE;
    private final ArrayList<Bizcocho> bizcochos;
    private final ArrayList<Factura> facturas;

    public Cliente(ArrayList<Bizcocho> bizcochos, ArrayList<Factura> facturas, int numeroCliente) {
        this.bizcochos = bizcochos;
        this.facturas = facturas;
        this.NUMERO_CLIENTE = numeroCliente;
    }

    @Override
    public void run() {
        System.out.println("Cliente " + NUMERO_CLIENTE + " ingreso a la panaderia");

        synchronized (bizcochos) {
            while (bizcochos.isEmpty()) {
                System.out.println("Cliente " + NUMERO_CLIENTE + " : No hay bizcochos en el mostrador... Esperando...");
                try {
                    bizcochos.wait();
                    System.out.println("Cliente " + NUMERO_CLIENTE + " : comprando...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            bizcochos.remove(0);
        }

        synchronized (facturas) {
            while (facturas.isEmpty()) {
                System.out.println("Cliente " + NUMERO_CLIENTE + " : No hay facturas en el mostrador... Esperando...");
                try {
                    facturas.wait();
                    System.out.println("Cliente " + NUMERO_CLIENTE + " : comprando...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            facturas.remove(0);
        }

        System.out.println("Cliente " + NUMERO_CLIENTE + " : finalizo su compra...");
        ToolThread.sleep(200, 400);
    }
}
