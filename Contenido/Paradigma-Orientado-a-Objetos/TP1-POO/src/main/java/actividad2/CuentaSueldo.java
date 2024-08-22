package actividad2;

import actividad1.CuentaBancaria;

import java.util.Scanner;

public class CuentaSueldo extends CuentaBancaria {
    private int legajo;
    private String institucion;
    private String beneficios;
    private long cbu;
    private double tope;

    public CuentaSueldo() {
        this(123456789123456789L);
    }

    public CuentaSueldo(long cbu) {
        super();
        setLegajo(111111);
        setInstitucion("Institucion1");
        setBeneficios("Beneficio1");
        setCbu(validarCbu(cbu));
        setTope(15000);
    }

    @Override
    public void retirar(double monto) {
        if (monto <= 0) avisoSaldo("El monto a retira no es valido");
        else if (monto > getTope()) avisoSaldo("No se pudo retirar " + monto + "$. El monto exede el tope de " + getTope() + "$.");
        else if (monto > getSaldo()) avisoSaldo("No se pudo retirar " + monto + "$. Saldo insuficiente");
        else {
            setSaldo(getSaldo() - monto);
            setTope(getTope() - monto);
            avisoSaldo("Retiro de " + monto + "$ exitoso. El tope se actualizo a " + getTope() + "$.");
        }
    }

    public void trasferir(double monto, long cbu) {
        if (monto <= 0) avisoSaldo("El monto a trasferir no es valido");
        else if (monto > getTope()) avisoSaldo("No se pudo trasferir " + monto + "$. El monto exede el tope de " + getTope() + "$.");
        else if (monto > getSaldo()) avisoSaldo("No se pudo trasferir " + monto + "$. Saldo insuficiente");
        else {
            setSaldo(getSaldo() - monto);
            setTope(getTope() - monto);
            avisoSaldo("Se tranfirio " + monto + "$ al CBU: " + cbu + ". El tope se actualizo a " + getTope() + "$.");
        }
    }

    public void trasferir(double monto, String alias) {
        if (monto <= 0) avisoSaldo("El monto a trasferir no es valido");
        else if (monto > getTope()) avisoSaldo("No se pudo trasferir " + monto + "$. El monto exede el tope de " + getTope() + "$.");
        else if (monto > getSaldo()) avisoSaldo("No se pudo trasferir " + monto + "$. Saldo insuficiente");
        else {
            setSaldo(getSaldo() - monto);
            setTope(getTope() - monto);
            avisoSaldo("Se tranfirio " + monto + "$ al alias: " + alias + ". El tope se actualizo a " + getTope() + "$.");
        }
    }

    private long validarCbu(Long cbu) {
        Scanner scanner = new Scanner(System.in);
        String scbu;
        while (true) {
            scbu = cbu.toString();
            if (scbu.length() == 18) return cbu;
            System.out.println("\nError el CBU no es valido. Ingrese un  CBU de 18 digitos");
            cbu = scanner.nextLong();
        }
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public long getCbu() {
        return cbu;
    }

    public void setCbu(long cbu) {
        this.cbu = cbu;
    }

    public double getTope() {
        return tope;
    }

    public void setTope(double tope) {
        this.tope = tope;
    }

    @Override
    public String toString() {
        return String.format("%n######### Datos de la cuenta #########%n" +
                        "N° de cuenta: %d%n" +
                        "DNI: %d%n" +
                        "Interes anual: %.2f%%%n" +
                        "Legajo: %d%n" +
                        "Institución: %s%n" +
                        "Beneficios: %s%n" +
                        "CBU: %d%n" +
                        "Saldo: %.2f%n" +
                        "Tope de retiro: %.2f%n" +
                        "######################################",
                getNUMERO_CUENTA(),getDni(),getInteresAnual(),getLegajo(),getInstitucion(),getBeneficios(),getCbu(),getSaldo(),getTope());
    }
}
