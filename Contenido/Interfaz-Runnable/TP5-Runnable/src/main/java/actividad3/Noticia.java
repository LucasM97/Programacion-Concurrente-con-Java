package actividad3;

public class Noticia {
    private String titulo;
    private String cuerpo;

    public Noticia(String titulo, String cuerpo) {
        setTitulo(titulo);
        setCuerpo(cuerpo);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
}
