package actividad2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Factura> facturas = new ArrayList<>();
        ArrayList<Bizcocho> bizcochos = new ArrayList<>();

        HornoBizcocho hBizcochos = new HornoBizcocho(bizcochos);
        HornoFactura hFacturas = new HornoFactura(facturas);

        hBizcochos.start();
        hFacturas.start();

        int numeroCliente = 1;

        while (true) {
            Cliente cliente = new Cliente(bizcochos, facturas, numeroCliente);
            cliente.start();
            ToolThread.sleep(800, 1500);
            numeroCliente++;
        }
    }
}
