package FigurasAvanzadas;

public class App {
    /**
     * Esta clase es de utilidad para ejecutar el programa como
     * un todo. No se la utiliza dentro de BlueJ.
     */
    public static void main(String[] args) throws Exception {
        App app = new App();

        // Ejecuta las acciones para la implementacion con for-each
        // app.figurasStandard();

        // Ejecuta las acciones para la implementacion con Stream
        app.figurasStream();

    }


    void figurasStandard () {
        GestorFiguras g = new GestorFiguras();
        g.crearFigurasAleatoriamente(5000000);
        System.out.println("Hay " + g.getFiguras().size() + " figuras");
        System.out.println(g.listarRectangulos().size() + " figuras son rectangulos");
        System.out.println(g.listarMayoresA(50000.0).size() + " figuras son mayores");
    }

    void figurasStream () {
        GestorFiguras g = new GestorFiguras();
        g.crearFigurasAleatoriamenteStream(500000);
        System.out.println("Hay " + g.getFiguras().size() + " figuras");
        System.out.println(g.listarRectangulosStream().size() + " figuras son rectangulos");
        System.out.println(g.listarMayoresAStream(50000.0).size() + " figuras son mayores");
    }

}
