package actividad3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        ArrayList<String> newsUrls = new ArrayList<>();
        newsUrls.add("https://eltribunodejujuy.com/policiales/2024-9-25-21-46-0-abuso-de-su-hermana-y-fue-condenado-a-ocho-anos");
        newsUrls.add("https://eltribunodejujuy.com/politica/2024-9-16-19-20-0-hoy-comienza-los-operativos-de-limpieza-en-rio-blanco");
        newsUrls.add("https://eltribunodejujuy.com/policiales/2024-9-25-19-56-0-robo-a-un-remisero-y-fue-atrapado-por-transeuntes");
        newsUrls.add("https://eltribunodejujuy.com/policiales/2024-9-25-21-56-0-la-justicia-no-actuo-de-forma-arbitraria-dijo-el-fiscal-mora");
        newsUrls.add("https://eltribunodejujuy.com/policiales/2024-9-24-20-6-0-fue-agredido-de-un-botellazo-en-la-cabeza");
        newsUrls.add("https://eltribunodejujuy.com/policiales/2024-9-25-21-26-0-gritos-y-amenazas-a-un-fiscal-tras-lectura-de-fallo");
        newsUrls.add("https://eltribunodejujuy.com/policiales/2024-9-26-11-27-0-reclamo-de-justicia-de-familiares-y-amigos-de-por-el-caso-de-ruben-pocho-oviedo");
        newsUrls.add("https://eltribunodejujuy.com/policiales/2024-9-25-19-22-0-la-justicia-absolvio-a-4-personas-acusadas-por-la-muerte-de-una-mujer-en-plena-pandemia");
        newsUrls.add("https://eltribunodejujuy.com/policiales/2024-9-24-20-6-0-pareja-fue-asaltada-y-herida-con-un-elemento-cortante");
        newsUrls.add("https://eltribunodejujuy.com/policiales/2024-9-24-19-36-0-piden-que-un-condenado-sea-trasladado-a-otra-carcel");



        ArrayList<Thread> threads = new ArrayList<>();

        // Lanzar 10 hilos
        for (int i = 0; i < newsUrls.size(); i++) {
            Thread thread = new Thread(new RequestNoticia(newsUrls, i));
            thread.start();
            threads.add(thread); // Guardar el hilo en la lista
        }

        // Esperar a que todos los hilos terminen
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Tiempo total de ejecución: " + (endTime - startTime) + " ms");
    }
}

