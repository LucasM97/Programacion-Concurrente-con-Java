package actividad4;

public abstract class Forma {
    private String nombreForma;

    public abstract double area();
    public abstract double perimetro();

    public String getNombreForma() {
        return nombreForma;
    }

    public void setNombreForma(String nombreForma) {
        this.nombreForma = nombreForma;
    }
}
