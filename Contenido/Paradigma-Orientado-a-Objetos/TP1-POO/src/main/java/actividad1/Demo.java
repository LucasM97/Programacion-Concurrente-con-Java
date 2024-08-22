package actividad1;

public class Demo {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria();
        System.out.println(cuenta1);

        CuentaBancaria cuenta2 = new CuentaBancaria();
        System.out.println(cuenta2);

        CuentaBancaria cuenta3 = new CuentaBancaria(35175628,3000,25);
        System.out.println(cuenta3);

        cuenta3.actualizarSaldo();

        cuenta3.ingresar(5000);

        cuenta3.retirar(10000);

        cuenta3.retirar(7000);

        cuenta3.actualizarSaldo();
    }

}
