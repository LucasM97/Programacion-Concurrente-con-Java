package actividad3;

import java.util.ArrayList;

public class Persona extends Thread {
    private final int NUMERO_PERSONA;
    private Pasillo pasillo;
    private final ArrayList<Persona> filaEntrada;
    private final ArrayList<Persona> filaSalida;

    public Persona(Pasillo pasillo, ArrayList<Persona> filaEntrada, ArrayList<Persona> filasalida, int numeroPersona) {
        this.NUMERO_PERSONA = numeroPersona;
        this.pasillo = pasillo;
        this.filaEntrada = new ArrayList<>();
        this.filaSalida = new ArrayList<>();
    }

    @Override
    public void run() {
        System.out.println("Persona " + NUMERO_PERSONA + ": llego al Zoo");
        System.out.println("Persona " + NUMERO_PERSONA + ": esperando en la fila de entrada");
        synchronized (pasillo) {
            pasillo.add();
            cruzarPasillo(this);
            pasillo.remove();
        }

        paseandoZoo(this);

        System.out.println("Persona " + NUMERO_PERSONA + ": esperando en la fila de salida");
        synchronized (pasillo) {
            pasillo.add();
            cruzarPasillo(this);
            pasillo.remove();
        }

        System.out.println("Persona " + NUMERO_PERSONA + ": se fue del Zoo");
    }

    public void cruzarPasillo(Persona persona) {
        System.out.println("Persona " + persona.NUMERO_PERSONA + ": comenzo a cruzar el pasillo");
        ToolThread.sleepThread(50);
        System.out.println("Persona " + persona.NUMERO_PERSONA + ": termino de cruzar el pasillo");
    }

    public void paseandoZoo(Persona persona) {
        System.out.println("Persona " + persona.NUMERO_PERSONA + ": comenzo a pasear");
        ToolThread.sleepThread(400, 700);
        System.out.println("Persona " + persona.NUMERO_PERSONA + ": termino de pasear");
    }
}
