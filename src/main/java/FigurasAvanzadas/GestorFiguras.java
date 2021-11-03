package FigurasAvanzadas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GestorFiguras {
    // HerramientaDeAzar provee las funcionalidades para
    // la generacion de objetos aleatoriamente.
    private HerramientaDeAzar generador;
    // Coleccion para almacenar los objetos a usar
    private List<FiguraGeometrica> figuras;

    /**
     * Inicializa la aplicacion.
     * Debe construir los objetos HerramientaDeAzar y
     * la coleccion de figuras geometricas.
     */
    public GestorFiguras () {
        generador = new HerramientaDeAzar();
        figuras = new ArrayList<>();
    }

    public List<FiguraGeometrica> getFiguras () {
        return figuras;
    }

    public HerramientaDeAzar getAzar () {
        return generador;
    }
    
    /**
     * Agrega una figura geometrica a la coleccion.
     * @param f La figura para agregar.
     */
    public void agregarFigura (FiguraGeometrica f) {
        figuras.add(f);
    }

    /**
     * Agrega una figura geometrica aleatoria a la coleccion.
     * Se solicita la figura a la clase HerramientaDeAzar.
     */
    public void agregarFiguraAleatoria () {
        agregarFigura(generador.getFiguraAleatoria());
    }

    /**
     * Crea la cantidad de figuras indicadas y las incorpora
     * a la coleccion. Las figuras se generan aleatoriamente
     * mediante la clase HerramientaDeAzar.
     * @param cantidad La cantidad de figuras a crear.
     */
    public void crearFigurasAleatoriamente(Integer cantidad) {
        for (Integer i = 0; i < cantidad ; i++) {
            try {
                agregarFiguraAleatoria();
            } catch (IllegalStateException e) {
            }
        }
    }

    /**
     * Crea la cantidad de figuras indicadas y las incorpora
     * a la coleccion. Las figuras se generan aleatoriamente
     * mediante la clase HerramientaDeAzar.
     * @param cantidad La cantidad de figuras a crear.
     */
    public void crearFigurasAleatoriamenteStream(Integer cantidad) {
        Stream.generate(generador::getFiguraAleatoria)
              .limit(cantidad).forEach(figuras::add);
    }


    /**
     * Genera una lista de figuras geometricas con superficie mayor 
     * a la indicada.
     * @param superficie
     * @return
     */
public List<FiguraGeometrica> listarMayoresA (Double superficie) {
    // Variable bandera indica si se uso -> funciona como lacrado
    List<FiguraGeometrica> lista = new ArrayList<>();
    for (FiguraGeometrica f : figuras) {
        if (f.getSuperficie() > superficie) {
            lista.add(f);
        }
    }
    return lista;
}

    /**
     * Genera una lista de figuras geometricas con superficie mayor 
     * a la indicada.
     * @param superficie
     * @return
     */
public List<FiguraGeometrica> listarMayoresAStream (Double superficie) {
    return figuras.stream()
                  .filter(x -> x.getSuperficie() > superficie)
                  .collect(Collectors.toList());
}

    /**
     * Genera una lista de rectangulos.
     * @return
     */
public List<FiguraGeometrica> listarRectangulos () {
    List<FiguraGeometrica> lista = new ArrayList<>();
    for (FiguraGeometrica f : figuras) {
        try {
            lista.add((Rectangulo)f);
        } catch (ClassCastException e) {
        }
    }
    return lista;
}

    /**
     * Genera una lista de rectangulos mediante Streams.
     * @return
     */
public List<FiguraGeometrica> listarRectangulosStream () {
    return figuras.stream()
                  .filter(f -> f.getClass() == Rectangulo.class)
                  .collect(Collectors.toList());
}


/* ****** Los siguentes metodos no corresponden al TP ****** */

    /**
     * Muestra por pantalla la informacion de todas las figuras
     * geometricas coleccionadas usando toString().
     */
    public void listarFigurasColeccionadas() {
        // Recorrido sobre todos los elementos

        // 1) Con for-each (para cualquier Collection)
        for (FiguraGeometrica f : figuras) {
            System.out.println(f);
        }

        // 2) Con for comun (solo para ArrayList)
        // for (Integer i = 0; i < figuras.size() ; i++) {
        //     System.out.println(figuras.get(i));
        // }

        // 3) While con Iterator (cualquier Collection)
        // Iterator<FiguraGeometrica> it = figuras.iterator();
        // while (it.hasNext()) {
        //     FiguraGeometrica f = it.next();
        //     System.out.println(f);
        // }
    }

    /**
     * Muestra por pantalla la informacion de todas las figuras
     * geometricas coleccionadas usando toString() pero ordenadas
     * en su orden natural.
     */
    public void listarFigurasOrdenadas() {
        TreeSet<FiguraGeometrica> fig = new TreeSet<>(figuras);
        for (FiguraGeometrica f : fig) {
            System.out.println(f);
        }
    }

    /**
     * Verifica que todos los elementos sean menores.
     * Ninguno es mayor.
     * @param superficie
     * @return
     */
    public Boolean ningunoMayorA (Integer superficie) {
        // Variable bandera indica si se uso -> funciona como lacrado
        Boolean ninguno = true;
        for (FiguraGeometrica f : figuras) {
            if (f.getSuperficie() > superficie) {
                ninguno = false;
            }
        }
        return ninguno;
    }

    /**
     * Verifica que todos cumplan la condicion.
     * @param superficie
     * @return
     */
    public Boolean todosMayorA (Integer superficie) {
        Boolean todos = true;
        for (FiguraGeometrica f : figuras) {
            if (f.getSuperficie() < superficie) {
                todos = false;
            }
        }
        return todos;
    }

    /**
     * Verifica que al menos uno cumpla la condicion.
     * @param superficie
     * @return
     */
    public Boolean alMenosUnoMayorA (Integer superficie) {
        Boolean uno = false;
        // Recorre toda la lista
        // for (FiguraGeometrica f : figuras) {
        //     if (f.getSuperficie() > superficie) {
        //         uno = true;
        //     }
        // }
        // Alternativa: Recorre hasta econtrar o llega al final
        Iterator<FiguraGeometrica> it = figuras.iterator();
        while ((it.hasNext()) && (!uno)) {
            FiguraGeometrica fig = it.next();
            if (fig.getSuperficie() > superficie) {
                uno = true;
            }
        }
        return uno;
    }

    /**
     * Muestra por pantalla la informacion de todas las figuras
     * geometricas coleccionadas usando toString() pero ordenadas
     * segun la distancia a la posicion indicada.
     * Agregar al toString() de las figuras geometricas una linea
     * con el formato
     *      " -- Distancia=X"
     * donde X es la distancia al origen.
     */
    public void listarFigurasSegunDistanciaAlOrigen() {
        // TODO - Implementar el metodo
    }

}
