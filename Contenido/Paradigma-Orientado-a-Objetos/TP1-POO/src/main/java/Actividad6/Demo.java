package Actividad6;

public class Demo {
    public static void main(String[] args) {
        Cuadrilatero cuadrilatero = new Cuadrilatero(3, 5);

        System.out.println(cuadrilatero.NOMBRE);
        System.out.println("Base: " + cuadrilatero.getBase() + " Altura: " + cuadrilatero.getAltura());
        System.out.printf("Area: %.2f", cuadrilatero.area());
        System.out.printf("%nPerimetro: %.2f", cuadrilatero.perimetro());
    }
}
