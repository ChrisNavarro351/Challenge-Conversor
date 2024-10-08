import java.util.Map;

public class ConversorMoneda {
    private final ConversorAPI conversorAPI;
    private Map<String, Double> tasaConversion;

    public ConversorMoneda() {
        this.conversorAPI = new ConversorAPI();
        this.tasaConversion = conversorAPI.obtenerTasas("USD");
    }

    public double convertir(String desde, String hacia, double cantidad) {

        if (tasaConversion == null || !tasaConversion.containsKey(desde) || !tasaConversion.containsKey(hacia)) {
            throw new RuntimeException("Error: tasaConversion de conversión no válidas.");
        }

        // Conversión de cualquier moneda elegida a USD
        double cantidadEnUSD = cantidad / tasaConversion.get(desde);
        // Conversión de USD a la moneda elegida :)
        return cantidadEnUSD * tasaConversion.get(hacia);
    }
}
