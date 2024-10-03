package actividad3;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class RequestNoticia implements Runnable {
    private ArrayList<String> urls;
    private int id;

    public RequestNoticia(ArrayList<String> url, int id) {
        this.urls = url;
        this.id = id;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        String respuesta = "";
        try {
            respuesta = peticionHttpGet(urls.get(id));
            // Usar JSoup para analizar el HTML
            Document doc = Jsoup.parse(respuesta);
            Element div = doc.select("div[amp-access=mostrarNota]").first();

            if (div != null) {
                String contenidoDiv = div.html();
                imprimirConFormato(contenidoDiv,id);
            } else {
                System.out.println("No se encontró el div con amp-access=\"mostrarNota\"");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución para la noticia " + id + ": " + (endTime - startTime) + " ms");
    }

    public static void imprimirConFormato(String texto,int id) {

        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_GREEN = "\u001B[32m";


        System.out.println(ANSI_BLUE + "=========================================" + ANSI_RESET);


        System.out.println(ANSI_GREEN + "  Contenido del Artículo "+ id + ANSI_RESET);


        System.out.println(ANSI_BLUE + "=========================================" + ANSI_RESET);


        System.out.println("\n\t" + texto + "\n");


        System.out.println(ANSI_BLUE + "=========================================" + ANSI_RESET);
    }

    @SuppressWarnings("deprecation")
    public static String peticionHttpGet(String urlParaVisitar) throws Exception {

        StringBuilder resultado = new StringBuilder();

        URL url = new URL(urlParaVisitar);

        // Abrir la conexión e indicar que será de tipo GET
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");
        // Búferes para leer
        BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String linea;
        // Mientras el BufferedReader se pueda leer, agregar contenido a resultado
        while ((linea = rd.readLine()) != null) {
            resultado.append(linea);
        }
        // Cerrar el BufferedReader
        rd.close();
        // Regresar resultado, pero como cadena, no como StringBuilder
        return resultado.toString();
    }
}
