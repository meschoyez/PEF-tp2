package FigurasAvanzadas;

public class Circulo extends FiguraGeometrica {
    private static final Double pi = Math.PI;
    // La constante se usa para BASE y ALTURA
    private static final Double MAX_RADIO = 500.0;
    // El numero de serie del primer objeto es 1
    // No se puede repetir el numero para dos triangulos
    private static Integer nroSerie = 0;
    private Double radio;

    /**
     * Constructor que recibe los valores de la base
     * y de la altura.
     * Debe generar el ID con la forma
     *    "CirculoX"
     * siendo X el numero de serie correspondiente.
     * Configurarlo con setId() de la superclase.
     */
    public Circulo(Integer diametro) {
        setRadio(diametro / 2.0);
        setId("Circulo" + getNroSerie());
    }

    /**
     * Calcula el perimetro de la figura.
     * @return El perimetro.
     */
    public Double getPerimetro() {
        return pi * 2 * radio;
    }

    /**
     * Calcula la superficie de la figura.
     * @return La superficie.
     */
    public Double getSuperficie() {
        return pi * radio * radio;
    }

    public Double getRadio() {
        return radio;
    }

    public Double getDiametro() {
        return radio * 2.0;
    }

    public void setRadio(Double radio) {
        this.radio = MAX_RADIO;
        if ((0 < radio) && (radio < MAX_RADIO)) {
            this.radio = radio;
        }
    }

    /**
     * Compara el triangulo con cualquier otra figura geometrica
     * devolviendo -1, 0 o 1 segun sea menor, igual o mayor.
     * La comparacion se hace primero por superficie y luego por ID
     * de los objetos. En ambos casos en el orden natural.
     * @return El entero indicando la comparacion.
     */
    @Override
    public int compareTo(FiguraGeometrica f) {
        int r = getSuperficie().compareTo(f.getSuperficie());
        if (r == 0) {
            r = (int)Math.signum( getId().compareTo(f.getId()) );
        }
        return r;
    }

    // Solo valido para el ejemplo de Set y Map
    @Override
    public boolean equals (Object f) {
        Circulo r = (Circulo)f;
        return getSuperficie().equals(r.getSuperficie());
    }

    /**
     * Genera un numero unico para cada objeto creado.
     * @return El numero de serie a usar.
     */
    private Integer getNroSerie() {
        nroSerie += 1;
        return nroSerie;
    }

    /**
     * Devuelve lo reportado en el toString() de la superclase
     * y le agrega el radio el circulo con el formato
     *   " ++ Radio=x"
     * siendo x el valor del campo.
     * @return El texto asociado.
     */
    @Override
    public String toString() {
        return "Figura Circulo\n ++ Radio=" + radio;
    }

}