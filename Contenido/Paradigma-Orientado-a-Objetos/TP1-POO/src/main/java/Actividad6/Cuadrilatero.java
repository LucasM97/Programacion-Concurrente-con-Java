package Actividad6;

public class Cuadrilatero implements Forma {
    public String NOMBRE = "Cuadrilatero";
    private double base;
    private double altura;

    public Cuadrilatero() {
        this(4, 4);
    }

    public Cuadrilatero(double base, double altura) {
        setBase(base);
        setAltura(altura);
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public double area() {
        return getBase() * getAltura();
    }

    @Override
    public double perimetro() {
        return 2 * (getBase() + getAltura());
    }
}
