public class FabricaFord extends Fabrica{
    @Override
    Car entregarCarro(String modelo) {
        if("Focus".equals(modelo)) {
            return new FordFocus("Focus", 2010, 100, "FBCV-1563");
        } else if("Fiesta".equals(modelo)) {
            return new FordFiesta("Fiesta", 2008, 80, "SDER-2154");
        } else if("Puma".equals(modelo)) {
            return new FordPuma("Puma", 2020, 120, "LKJF-4386");
        } else if("Ka".equals(modelo)) {
            return new FordKa("Ka", 2013, 90, "NSWE-9932");
        } else {
            return null;
        }
    }
}
