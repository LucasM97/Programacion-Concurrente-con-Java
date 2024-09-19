package actividad2;

import java.util.ArrayList;

public class HornoFactura extends Thread {
    private final ArrayList<Factura> facturas;

    public HornoFactura(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }

    @Override
    public void run() {
        int numero = 1;

        while (true) {
            System.out.println("Horno de Factura: Produciendo... ");
            ToolThread.sleep(1000, 1300);
            Factura factura = new Factura(numero);

            System.out.println("Horno de Factura: Se produjo... " + factura.getNOMBRE() + " numero " + factura.getNUMERO());

            synchronized (facturas) {
                facturas.add(factura);
                facturas.notify();
            }

            numero++;
        }
    }
}
