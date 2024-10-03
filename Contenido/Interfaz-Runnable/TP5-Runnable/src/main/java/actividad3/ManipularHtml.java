package actividad3;

public class ManipularHtml {
    private static final String ETIQUETA_TITULO = "<h1 class=\"articulo__titulo\">";
    private static final String ETIQUETA_CUERPO = "<div amp-access=\"mostrarNota\">";
    private static final String ETIQUETA_SALIDA = "<div class=\"tags mobile\">";

    public static String extraerTitulo(String html) {
        Integer posicion = html.indexOf(ETIQUETA_TITULO) + ETIQUETA_TITULO.length();
        Character caracter = ' ';
        StringBuilder sb = new StringBuilder();

        while (!caracter.equals('<')) {
            posicion++;
            caracter = html.charAt(posicion);
            sb.append(caracter);
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static String extraerCuerpo(String html) {
        Integer posicion = html.indexOf(ETIQUETA_CUERPO) + ETIQUETA_CUERPO.length() - 1;
        Integer salida = html.indexOf(ETIQUETA_SALIDA);
        Character caracter = ' ';
        Character caracterAnterior = ' ';
        Boolean copiar = true;

        StringBuilder sb = new StringBuilder();

        while (posicion < salida) {
            caracter = html.charAt(posicion);
            caracterAnterior = html.charAt(posicion - 1);
            if (caracter.equals('>') && caracterAnterior.equals('p')) {
                copiar = true;
                sb.deleteCharAt(sb.length() - 1);
                sb.append("\n");
            }
            while (copiar && !caracter.equals('<')) {
                posicion++;
                caracter = html.charAt(posicion);
                sb.append(caracter);
            }
            copiar = false;
            posicion++;
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
