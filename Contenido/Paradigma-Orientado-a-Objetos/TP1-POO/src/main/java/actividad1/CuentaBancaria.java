package actividad1;

public class CuentaBancaria {
    private static long auxNumeroCuenta = 100001;
    private final Long NUMERO_CUENTA;
    private long dni;
    private double saldo;
    private double interesAnual;

    public CuentaBancaria() {
        this(11111111, 10000, 10);
    }

    public CuentaBancaria(long dni, double saldo, double interesAnual) {
        NUMERO_CUENTA = auxNumeroCuenta++;
        setDni(dni);
        setSaldo(saldo);
        setInteresAnual(interesAnual);
    }

    public void actualizarSaldo() {
        double interesDiario = getInteresAnual() / 100 / 365;
        double montoInteresDiario = getSaldo() * interesDiario;
        setSaldo(getSaldo() + montoInteresDiario);
        avisoSaldo("Se sumo el interes diario de " + Math.round(montoInteresDiario * 100.) / 100. + "$");
    }

    public void ingresar(double monto) {
        if (monto > 0) {
            setSaldo(getSaldo() + monto);
            avisoSaldo("Se ingreso " + monto + "$");
        } else avisoSaldo("No se pudo retirar " + monto + "$. Saldo insuficiente");
    }

    public void retirar(double monto) {
        if (monto <= 0) avisoSaldo("El monto a retira no es valido");
        else if (monto > getSaldo()) avisoSaldo("No se pudo retirar " + monto + "$. Saldo insuficiente");
        else {
            setSaldo(getSaldo() - monto);
            avisoSaldo("Retiro de " + monto + "$ exitoso");
        }
    }

    public void avisoSaldo(String mensaje) {
        System.out.printf("%nN° de Cuenta: %d%n%s%nSaldo: %.2f$%n", NUMERO_CUENTA, mensaje, getSaldo());
    }

    public Long getNUMERO_CUENTA() {
        return NUMERO_CUENTA;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public double getInteresAnual() {
        return interesAnual;
    }

    public void setInteresAnual(Double interesAnual) {
        this.interesAnual = interesAnual;
    }

    @Override
    public String toString() {
        return String.format("%n######### Datos de la cuenta #########%n" +
                        "N° de cuenta: %d%n" +
                        "DNI: %d%n" +
                        "Saldo: %.2f$%n" +
                        "Interes anual: %.2f%%%n" +
                        "######################################",
                NUMERO_CUENTA, getDni(), getSaldo(), getInteresAnual());
    }
}
