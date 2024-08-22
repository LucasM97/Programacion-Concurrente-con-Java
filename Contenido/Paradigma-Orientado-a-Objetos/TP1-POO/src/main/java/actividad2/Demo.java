package actividad2;

import actividad1.CuentaBancaria;

public class Demo {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria();
        System.out.println(cuenta1);

        CuentaBancaria cuenta2 = new CuentaSueldo();
        System.out.println(cuenta2);

        CuentaSueldo cuenta3 = new CuentaSueldo(546546);
        System.out.println(cuenta3);

        CuentaSueldo cuenta4 = new CuentaSueldo(987654321987654321L);
        System.out.println(cuenta4);

        cuenta4.ingresar(10000);

        cuenta4.retirar(16000);

        cuenta4.retirar(-1);

        cuenta4.retirar(3000);

        cuenta4.trasferir(16000, 987654321123456789L);

        cuenta4.trasferir(-1, 987654321123456789L);

        cuenta4.trasferir(6000, 987654321123456789L);
    }
}
