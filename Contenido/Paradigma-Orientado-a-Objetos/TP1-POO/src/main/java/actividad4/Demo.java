package actividad4;

public class Demo {
    public static void main(String[] args) {
        Cuadrilatero cuadrilatero = new Cuadrilatero(3, 5);
        cuadrilatero.setNombreForma("Cuadrilatero");

        System.out.println(cuadrilatero.getNombreForma());
        System.out.println("Base: " + cuadrilatero.getBase() + " Altura: " + cuadrilatero.getAltura());
        System.out.printf("Area: %.2f", cuadrilatero.area());
        System.out.printf("%nPerimetro: %.2f%n", cuadrilatero.perimetro());

        System.out.println("---------------------------------------------");

        Circulo circulo = new Circulo(4);
        circulo.setNombreForma("Circulo");

        System.out.println(circulo.getNombreForma());
        System.out.println("Radio: " + circulo.getRadio());
        System.out.printf("Area: %.2f", circulo.area());
        System.out.printf("%nPerimetro: %.2f", circulo.perimetro());
    }
}
