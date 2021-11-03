package FigurasAvanzadas;

public class Posicion implements Comparable<Posicion> {
    private Integer x;
    private Integer y;

    /**
     * Calcula la distancia entre la posicion y el origen (0,0).
     * @return La distancia al origen.
     */
    public Double distanciaAlOrigen () {
        // TODO - Implementar el metodo
        return -1.0;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    /**
     * Devuelve la posicion como un par ordenado, sin espacios en blanco.
     * @return El par ordenado.
     */
    public String toString() {
        // TODO - Implementar el metodo
        return "hola";
    }

    /**
     * Compara la posicion con cualquier otra posicion
     * devolviendo -1, 0 o 1 segun sea menor, igual o mayor la distancia al origen.
     * @return El entero indicando la comparacion.
     */
    @Override
    public int compareTo(Posicion otro) {
        // TODO - Implementar el metodo
        return 0;
    }
}
