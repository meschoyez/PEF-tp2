package FigurasAvanzadas;

public class Rectangulo extends FiguraGeometrica {
    // La constante se usa para BASE y ALTURA
    private static final Integer MAX_LADO = 500;
    // El numero de serie del primer objeto es 1
    // No se puede repetir el numero para dos triangulos
    private static Integer nroSerie = 0;
    private Integer base;
    private Integer altura;

    /**
     * Constructor que utiliza el mismo valor de la base
     * para la altura.
     * Debe generar el ID con la forma
     *    "RectanguloX"
     * siendo X el numero de serie correspondiente.
     * Configurarlo con setId() de la superclase.
     */
    public Rectangulo(Integer base) {
        setBase(base);
        setAltura(base);
        setId("Rectangulo" + getNroSerie());
    }

    /**
     * Constructor que recibe los valores de la base
     * y de la altura.
     * Debe generar el ID con la forma
     *    "RectanguloX"
     * siendo X el numero de serie correspondiente.
     * Configurarlo con setId() de la superclase.
     */
    public Rectangulo(Integer base, Integer altura) {
        setBase(base);
        setAltura(altura);
        setId("Rectangulo" + getNroSerie());
    }

    /**
     * Calcula el perimetro de la figura.
     * @return El perimetro.
     */
    public Double getPerimetro () {
        return 2.0 * base + 2.0 * altura;
    }

    /**
     * Calcula la superficie de la figura.
     * @return La superficie.
     */
    public Double getSuperficie () {
        return 1.0 * base * altura;
    }

    public Integer getBase() {
        return base;
    }

    /**
     * Configura la base controlando que sea mayor que cero
     * y menor que MAX_LADO.
     * @param altura La base a configurar.
     */
    public void setBase(Integer base) {
        this.base = MAX_LADO;
        if ((0 < base) && (base <= MAX_LADO)) {
            this.base = base;
        }
    }

    public Integer getAltura() {
        return altura;
    }

    /**
     * Configura la altura controlando que sea mayor que cero
     * y menor que MAX_LADO.
     * @param altura La altura a configurar.
     */
    public void setAltura(Integer altura) {
        this.altura = MAX_LADO;
        if ((0 < altura) && (altura <= MAX_LADO)) {
            this.altura = altura;
        }
    }

    /**
     * Compara el triangulo con cualquie otra figura geometrica
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
        Rectangulo r = (Rectangulo)f;
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
     * y le agrega la base y altura del rectangulo con el formato
     *   " ++ Altura=x, Base=y"
     * siendo x e y los valores de los campos.
     * @return El texto asociado.
     */
    @Override
    public String toString() {
        return super.toString() + " ++ Altura=" + altura + ", Base=" + base;
    }

}