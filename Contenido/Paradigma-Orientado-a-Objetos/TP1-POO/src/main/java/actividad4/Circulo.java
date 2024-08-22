package actividad4;

public class Circulo extends Forma {
    private double radio;

    public Circulo() {
        this(2);
    }

    public Circulo(double radio) {
        setRadio(radio);
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(getRadio(), 2);
    }

    @Override
    public double perimetro() {
        return 2 * Math.PI * getRadio();
    }
}
