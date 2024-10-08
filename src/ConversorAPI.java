import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConversorAPI {
    private static final String URL = "https://v6.exchangerate-api.com/v6/7e192f4a87d9c287bfcfe0b7/latest/";

    public Map<String, Double> obtenerTasas(String monedaBase) {
        URI direccion = URI.create(URL + monedaBase);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al obtener las tasas de cambio: " + e.getMessage());
        }


        Gson gson = new Gson();
        ApiResponse apiResponse = gson.fromJson(response.body(), ApiResponse.class);

        // Verificamos si las tasas de conversión están disponibles
        if (apiResponse == null || apiResponse.conversion_rates == null) {
            throw new RuntimeException("Error: la API no devolvió tasas de conversión válidas.");
        }

        return apiResponse.conversion_rates;
    }

    // Clase interna para mapear la respuesta JSON
    private static class ApiResponse {
        Map<String, Double> conversion_rates;
    }
}
