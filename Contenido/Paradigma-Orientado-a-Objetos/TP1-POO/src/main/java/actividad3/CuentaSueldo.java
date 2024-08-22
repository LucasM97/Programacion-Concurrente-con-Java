package actividad3;

import actividad1.CuentaBancaria;

import java.util.Scanner;

public class CuentaSueldo extends CuentaBancaria implements OperacionesBancarias{
    private int legajo;
    private String institucion;
    private String beneficios;
    private long cbu;
    private String alias;
    private final double TOPE;
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
        setAlias("LLLLLL");
        TOPE = 15000;
        setTope(TOPE);
    }

    @Override
    public void retirar(double monto) {
        if (monto <= 0) avisoSaldo("El monto a retira no es valido");
        else if (monto > getSaldo()) avisoSaldo("No se pudo retirar " + monto + "$. Saldo insuficiente");
        else if (monto > TOPE) transferenciaAltoMonto(monto);
        else if (monto > getTope()) avisoSaldo("No se pudo retirar " + monto + "$. El monto exede el tope de " + getTope() + "$.");
        else {
            setSaldo(getSaldo() - monto);
            setTope(getTope() - monto);
            avisoSaldo("Retiro de " + monto + "$ exitoso. El tope se actualizo a " + getTope() + "$.");
        }
    }

    public void trasferir(double monto, long cbu) {
        if (monto <= 0) avisoSaldo("El monto a trasferir no es valido");
        else if (monto > getSaldo()) avisoSaldo("No se pudo trasferir " + monto + "$. Saldo insuficiente");
        else if (monto > TOPE) transferenciaAltoMonto(monto);
        else if (monto > getTope()) avisoSaldo("No se pudo trasferir " + monto + "$. El monto exede el tope de " + getTope() + "$.");
        else {
            setSaldo(getSaldo() - monto);
            setTope(getTope() - monto);
            avisoSaldo("Se tranfirio " + monto + "$ al CBU: " + cbu + ". El tope se actualizo a " + getTope() + "$.");
        }
    }

    public void trasferir(double monto, String alias) {
        if (monto <= 0) avisoSaldo("El monto a trasferir no es valido");
        else if (monto > getSaldo()) avisoSaldo("No se pudo trasferir " + monto + "$. Saldo insuficiente");
        else if (monto > TOPE) transferenciaAltoMonto(monto);
        else if (monto > getTope()) avisoSaldo("No se pudo trasferir " + monto + "$. El monto exede el tope de " + getTope() + "$.");
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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
                        "Alias: %s%n" +
                        "Saldo: %.2f%n" +
                        "Tope de retiro: %.2f%n" +
                        "######################################",
                getNUMERO_CUENTA(),getDni(),getInteresAnual(),getLegajo(),getInstitucion(),getBeneficios(),getCbu(),getAlias(),getSaldo(),TOPE);
    }

    @Override
    public void pagarServicio() {
        double montoServicio;
        double montoReintegro;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el monto a pagar");
        montoServicio = scanner.nextDouble();

        montoServicio = montoServicio * (1 + IVA / 100);
        System.out.println("\nSe aplico un IVA de " + IVA + "% al monto a pagar.");

        if (montoServicio <= 0) avisoSaldo("El monto a pagar no es valido");
        else if (montoServicio > TOPE_PAGO) avisoSaldo("No se pudo pagar " + montoServicio + "$. El monto exede el tope de " + TOPE_PAGO + "$.");
        else if (montoServicio > getSaldo()) avisoSaldo("No se pudo trasferir " + montoServicio + "$. Saldo insuficiente");
        else {
            montoReintegro = montoServicio * PORCENTAJE_REINTEGRO / 100;
            System.out.println("Tendra un reintegro de " + montoReintegro + "$. Porcentaje de reintegro: " + PORCENTAJE_REINTEGRO + "%.");


            setSaldo(getSaldo() - montoServicio + montoReintegro);
            avisoSaldo("Se pago " + montoServicio + "$.");
        }
    }

    @Override
    public void cambiarAlias() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngrese el alias nuevo");
        setAlias(scanner.nextLine());
        System.out.println("\nEl alias fue modificado");
    }

    @Override
    public void transferenciaAltoMonto(double monto) {
        System.out.println("\nTrasferencia de alto monto");
        if (getSaldo() >= monto) {
            setSaldo(getSaldo() - monto);
            avisoSaldo("Se realizo una trasferencia de " + monto + "$.");
        } else avisoSaldo("El monto " + monto + "$ exede el saldo disponible");
    }
}
