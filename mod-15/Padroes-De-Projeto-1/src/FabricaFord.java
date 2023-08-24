public class FabricaFord extends Fabrica{
    @Override
    Car entregarCarro(String modelo) {
        if("Focus".equals(modelo)) {
            return new FordFocus("Focus", 2010, 100, "FBCV-1563");
        } else if("Fiesta".equals(modelo)) {
            return new FordFiesta("Focus", 2010, 100, "SDER-2154");
        } else if("Puma".equals(modelo)) {
            return new FordPuma("Focus", 2010, 100, "LKJF-4386");
        } else if("Ka".equals(modelo)) {
            return new FordKa("Focus", 2010, 100, "NSWE-9932");
        } else {
            return null;
        }
    }
}
