package actividad3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Persona> filaEntrada = new ArrayList<>();
        ArrayList<Persona> filaSalida = new ArrayList<>();
        Pasillo pasillo = new Pasillo();

        int numeroPersona = 1;

        while (true) {
            Persona persona = new Persona(pasillo, filaEntrada, filaSalida, numeroPersona);
            persona.start();
            ToolThread.sleepThread(100, 200);
            numeroPersona++;
        }
    }
}
