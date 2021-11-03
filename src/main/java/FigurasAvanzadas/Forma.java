package FigurasAvanzadas;

/*
    Un enumerado es una clase especial que se crea al
    iniciar el programa (no debo instanciarlo).

    Basicamente me sirve para usar etiquetas de clasificacion.
*/
public enum Forma {
    CIRCULO("Circulo"), RECTANGULO("Rectangulo"), TRIANGULO("Triangulo");

    private String tipo;

    private Forma(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }

}
