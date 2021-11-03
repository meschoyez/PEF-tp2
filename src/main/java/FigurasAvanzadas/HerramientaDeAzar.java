package FigurasAvanzadas;

import java.lang.reflect.Constructor;
import java.util.Random;

public class HerramientaDeAzar {
    Random dado;
    
    public HerramientaDeAzar () {
        dado = new Random();
    }

    public HerramientaDeAzar (long seed) {
        dado = new Random(seed);
    }

    public void setSeed (long seed) {
        dado.setSeed(seed);       
    }

public FiguraGeometrica getFiguraAleatoria () {
    FiguraGeometrica f;
    Forma forma = Forma.values()[dado.nextInt(Forma.values().length)];
    try {
        Class<?> c = Class.forName("FigurasAvanzadas." +
                           forma.toString());
        Constructor<?> constructor = c.getConstructor(Integer.class);
        f = (FiguraGeometrica)constructor.newInstance(getEntero(10, 500));
        f.getPosicion().setX(getEntero(0, 800));
        f.getPosicion().setY(getEntero(0, 600));
    }
    catch (Exception e) {
        System.out.println(e);
        throw new IllegalStateException(e.getMessage());
    }
    return f;
}

    public Integer getEntero (Integer desde, Integer hasta) {
        return dado.nextInt(hasta + desde) - desde;
    }
}
