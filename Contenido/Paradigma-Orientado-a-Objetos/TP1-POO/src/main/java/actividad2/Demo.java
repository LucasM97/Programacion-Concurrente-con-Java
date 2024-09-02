package actividad2;

import actividad1.CuentaBancaria;

public class Demo {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria();
        System.out.println(cuenta1);

        CuentaBancaria cuenta2 = new CuentaSueldo();
        System.out.println(cuenta2);

        System.out.println("\n----- Se intenta crear una cuenta con el CBU 546546");

        CuentaSueldo cuenta3 = new CuentaSueldo(546546);
        System.out.println(cuenta3);

        System.out.println("\n----- Se intenta crear una cuenta con el CBU 987654321987654321");

        CuentaSueldo cuenta4 = new CuentaSueldo(987654321987654321L);
        System.out.println(cuenta4);

        System.out.println("\n----- Se intenta ingresar 10000");

        cuenta4.ingresar(10000);

        System.out.println("\n----- Se intenta retirar 16000");

        cuenta4.retirar(16000);

        System.out.println("\n----- Se intenta retirar -1");

        cuenta4.retirar(-1);

        System.out.println("\n----- Se intenta retirar 3000");

        cuenta4.retirar(3000);

        System.out.println("\n----- Se intenta ingresar 20000");

        cuenta4.ingresar(20000);

        System.out.println("\n----- Se intenta trasferir 16000 al CBU: 987654321123456789");

        cuenta4.trasferir(16000, 987654321123456789L);

        System.out.println("\n----- Se intenta trasferir -1 al CBU: 987654321123456789");

        cuenta4.trasferir(-1, 987654321123456789L);

        System.out.println("\n----- Se intenta trasferir 6000 al Alias: AAAAAA");

        cuenta4.trasferir(6000, "AAAAAA");
    }
}
