import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Menuconversor {

    private static final HttpClient client = HttpClient.newHttpClient();
    private static final Gson gson = new Gson();

    public Conversor conversor(String baseCurrency, String targetCurrency, Double value) {
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/68e54c2ec128b93103eda570/pair/" + baseCurrency + "/" + targetCurrency + "/" + value);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), Conversor.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não consigo converter", e);
        }
    }
}